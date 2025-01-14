package com.maxlarsson.projectile;

import org.opensourcephysics.controls.AbstractSimulation;
import org.opensourcephysics.controls.SimulationControl;
import org.opensourcephysics.frames.PlotFrame;

import javax.swing.*;
import java.awt.*;

public class ProjectileApp extends AbstractSimulation {
    PlotFrame plotFrame;
    Particle particleWithoutAirResistance;
    Particle particleWithAirResistance;

    @Override
    public void initialize() {
        plotFrame = new PlotFrame("x", "y", "Projectile App");

        particleWithoutAirResistance = new Particle(0, 0, 50,  8, 10, 1);
        particleWithAirResistance = new Particle(0, 0, 50, 8, 10, 1);

        plotFrame.addDrawable(particleWithAirResistance);
        plotFrame.addDrawable(particleWithoutAirResistance);

        particleWithAirResistance.color = new Color(0, 255, 0);
        particleWithoutAirResistance.color = new Color(255, 0, 0);

        plotFrame.setPreferredMinMax(0, 110, 0, 10); // Scale of graph.
        plotFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Make it so x'ing out of the graph stops the program.
        plotFrame.setVisible(true); // Required to show plot frame.
    }

    @Override
    protected void doStep() {
//        double deltaTime = 1.0/12.0;
        double deltaTime = 0.05;
        double airpressure = 1.225;

        particleWithoutAirResistance.step(deltaTime);
        particleWithAirResistance.step(deltaTime, airpressure);
        System.out.println(particleWithAirResistance.getX());
    }

    /**
     * Required main method, runs the simulation.
     */
    public static void main(String[] args) {
        SimulationControl.createApp(new ProjectileApp());
    }
}
