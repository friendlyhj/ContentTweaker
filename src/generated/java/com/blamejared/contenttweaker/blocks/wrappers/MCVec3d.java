package com.blamejared.contenttweaker.blocks.wrappers;

import com.blamejared.contenttweaker.blocks.wrappers.MCVec3d;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.impl.util.MCDirectionAxis;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.ZenWrapper;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.Vec3d;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.contenttweaker.block.MCVec3d")
@Document("mods/contenttweaker/block/MCVec3d")
@ZenWrapper(wrappedClass = "net.minecraft.util.math.Vec3d", conversionMethodFormat = "%s.getInternal()", displayStringFormat = "%s.toString()")
public class MCVec3d {
    private final Vec3d internal;

    public MCVec3d(Vec3d internal){
        this.internal = internal;
    }

    public Vec3d getInternal() {
        return this.internal;
    }

    @ZenCodeType.Method
    public double dotProduct(MCVec3d vec) {
        return internal.dotProduct((vec).getInternal());
    }


    @ZenCodeType.Method
    public MCVec3d mul(double factorX, double factorY, double factorZ) {
        return new MCVec3d(internal.mul(factorX, factorY, factorZ));
    }


    @ZenCodeType.Method
    public double getCoordinate(MCDirectionAxis axis) {
        return internal.getCoordinate((axis).getInternal());
    }


    @ZenCodeType.Method
    public double getZ() {
        return internal.getZ();
    }


    /**
     * Normalizes the vector to a length of 1 (except if it is the zero vector)
     */
    @ZenCodeType.Method
    public MCVec3d normalize() {
        return new MCVec3d(internal.normalize());
    }


    @ZenCodeType.Method
    public double getY() {
        return internal.getY();
    }


    @ZenCodeType.Method
    public double squareDistanceTo(double xIn, double yIn, double zIn) {
        return internal.squareDistanceTo(xIn, yIn, zIn);
    }


    @ZenCodeType.Method
    public boolean equals(Object p_equals_1_) {
        return internal.equals((p_equals_1_));
    }


    @ZenCodeType.Method
    public double getX() {
        return internal.getX();
    }


    /**
     * Returns the length of the vector.
     */
    @ZenCodeType.Method
    public double length() {
        return internal.length();
    }


    @ZenCodeType.Method
    public MCVec3d subtract(double x, double y, double z) {
        return new MCVec3d(internal.subtract(x, y, z));
    }


    @ZenCodeType.Method
    public MCVec3d subtract(MCVec3d vec) {
        return new MCVec3d(internal.subtract((vec).getInternal()));
    }


    @ZenCodeType.Method
    public MCVec3d add(MCVec3d vec) {
        return new MCVec3d(internal.add((vec).getInternal()));
    }


    /**
     * Returns a new vector with the result of this vector x the specified vector.
     */
    @ZenCodeType.Method
    public MCVec3d crossProduct(MCVec3d vec) {
        return new MCVec3d(internal.crossProduct((vec).getInternal()));
    }


    @ZenCodeType.Method
    public double squareDistanceTo(MCVec3d vec) {
        return internal.squareDistanceTo((vec).getInternal());
    }


    @ZenCodeType.Method
    public MCVec3d rotatePitch(float pitch) {
        return new MCVec3d(internal.rotatePitch(pitch));
    }


    @ZenCodeType.Method
    public MCVec3d mul(MCVec3d p_216369_1_) {
        return new MCVec3d(internal.mul((p_216369_1_).getInternal()));
    }


    @ZenCodeType.Method
    public String toString() {
        return (internal.toString());
    }


    @ZenCodeType.Method
    public double lengthSquared() {
        return internal.lengthSquared();
    }


    /**
     * Returns a new vector with the result of the specified vector minus this.
     */
    @ZenCodeType.Method
    public MCVec3d subtractReverse(MCVec3d vec) {
        return new MCVec3d(internal.subtractReverse((vec).getInternal()));
    }


    @ZenCodeType.Method
    public MCVec3d add(double x, double y, double z) {
        return new MCVec3d(internal.add(x, y, z));
    }


    @ZenCodeType.Method
    public MCVec3d rotateYaw(float yaw) {
        return new MCVec3d(internal.rotateYaw(yaw));
    }


    /**
     * Euclidean distance between this and the specified vector, returned as double.
     */
    @ZenCodeType.Method
    public double distanceTo(MCVec3d vec) {
        return internal.distanceTo((vec).getInternal());
    }


    @ZenCodeType.Method
    public MCVec3d inverse() {
        return new MCVec3d(internal.inverse());
    }


    @ZenCodeType.Method
    public int hashCode() {
        return internal.hashCode();
    }


    @ZenCodeType.Method
    public MCVec3d scale(double factor) {
        return new MCVec3d(internal.scale(factor));
    }


}