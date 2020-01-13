package com.facebook.rebound;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes5.dex */
public class Spring {
    private static int ID = 0;
    private static final double MAX_DELTA_TIME_SEC = 0.064d;
    private static final double SOLVER_TIMESTEP_SEC = 0.001d;
    private double mEndValue;
    private final String mId;
    private boolean mOvershootClampingEnabled;
    private SpringConfig mSpringConfig;
    private final BaseSpringSystem mSpringSystem;
    private double mStartValue;
    private final PhysicsState mCurrentState = new PhysicsState();
    private final PhysicsState mPreviousState = new PhysicsState();
    private final PhysicsState mTempState = new PhysicsState();
    private boolean mWasAtRest = true;
    private double mRestSpeedThreshold = 0.005d;
    private double mDisplacementFromRestThreshold = 0.005d;
    private CopyOnWriteArraySet<SpringListener> mListeners = new CopyOnWriteArraySet<>();
    private double mTimeAccumulator = 0.0d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PhysicsState {
        double position;
        double velocity;

        private PhysicsState() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spring(BaseSpringSystem baseSpringSystem) {
        if (baseSpringSystem == null) {
            throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
        }
        this.mSpringSystem = baseSpringSystem;
        StringBuilder append = new StringBuilder().append("spring:");
        int i = ID;
        ID = i + 1;
        this.mId = append.append(i).toString();
        setSpringConfig(SpringConfig.defaultConfig);
    }

    public void destroy() {
        this.mListeners.clear();
        this.mSpringSystem.deregisterSpring(this);
    }

    public String getId() {
        return this.mId;
    }

    public Spring setSpringConfig(SpringConfig springConfig) {
        if (springConfig == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.mSpringConfig = springConfig;
        return this;
    }

    public SpringConfig getSpringConfig() {
        return this.mSpringConfig;
    }

    public Spring setCurrentValue(double d) {
        return setCurrentValue(d, true);
    }

    public Spring setCurrentValue(double d, boolean z) {
        this.mStartValue = d;
        this.mCurrentState.position = d;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onSpringUpdate(this);
        }
        if (z) {
            setAtRest();
        }
        return this;
    }

    public double getStartValue() {
        return this.mStartValue;
    }

    public double getCurrentValue() {
        return this.mCurrentState.position;
    }

    public double getCurrentDisplacementDistance() {
        return getDisplacementDistanceForState(this.mCurrentState);
    }

    private double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.mEndValue - physicsState.position);
    }

    public Spring setEndValue(double d) {
        if (this.mEndValue != d || !isAtRest()) {
            this.mStartValue = getCurrentValue();
            this.mEndValue = d;
            this.mSpringSystem.activateSpring(getId());
            Iterator<SpringListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onSpringEndStateChange(this);
            }
        }
        return this;
    }

    public double getEndValue() {
        return this.mEndValue;
    }

    public Spring setVelocity(double d) {
        if (d != this.mCurrentState.velocity) {
            this.mCurrentState.velocity = d;
            this.mSpringSystem.activateSpring(getId());
        }
        return this;
    }

    public double getVelocity() {
        return this.mCurrentState.velocity;
    }

    public Spring setRestSpeedThreshold(double d) {
        this.mRestSpeedThreshold = d;
        return this;
    }

    public double getRestSpeedThreshold() {
        return this.mRestSpeedThreshold;
    }

    public Spring setRestDisplacementThreshold(double d) {
        this.mDisplacementFromRestThreshold = d;
        return this;
    }

    public double getRestDisplacementThreshold() {
        return this.mDisplacementFromRestThreshold;
    }

    public Spring setOvershootClampingEnabled(boolean z) {
        this.mOvershootClampingEnabled = z;
        return this;
    }

    public boolean isOvershootClampingEnabled() {
        return this.mOvershootClampingEnabled;
    }

    public boolean isOvershooting() {
        return this.mSpringConfig.tension > 0.0d && ((this.mStartValue < this.mEndValue && getCurrentValue() > this.mEndValue) || (this.mStartValue > this.mEndValue && getCurrentValue() < this.mEndValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void advance(double d) {
        boolean z;
        boolean z2;
        boolean isAtRest = isAtRest();
        if (!isAtRest || !this.mWasAtRest) {
            if (d > MAX_DELTA_TIME_SEC) {
                d = MAX_DELTA_TIME_SEC;
            }
            this.mTimeAccumulator += d;
            double d2 = this.mSpringConfig.tension;
            double d3 = this.mSpringConfig.friction;
            double d4 = this.mCurrentState.position;
            double d5 = this.mCurrentState.velocity;
            double d6 = this.mTempState.position;
            double d7 = this.mTempState.velocity;
            while (this.mTimeAccumulator >= SOLVER_TIMESTEP_SEC) {
                this.mTimeAccumulator -= SOLVER_TIMESTEP_SEC;
                if (this.mTimeAccumulator < SOLVER_TIMESTEP_SEC) {
                    this.mPreviousState.position = d4;
                    this.mPreviousState.velocity = d5;
                }
                double d8 = ((this.mEndValue - d6) * d2) - (d3 * d5);
                double d9 = d5 + (SOLVER_TIMESTEP_SEC * d8 * 0.5d);
                double d10 = ((this.mEndValue - (((SOLVER_TIMESTEP_SEC * d5) * 0.5d) + d4)) * d2) - (d3 * d9);
                double d11 = d5 + (SOLVER_TIMESTEP_SEC * d10 * 0.5d);
                double d12 = ((this.mEndValue - (((SOLVER_TIMESTEP_SEC * d9) * 0.5d) + d4)) * d2) - (d3 * d11);
                d6 = d4 + (SOLVER_TIMESTEP_SEC * d11);
                d7 = (SOLVER_TIMESTEP_SEC * d12) + d5;
                d4 += (((d9 + d11) * 2.0d) + d5 + d7) * 0.16666666666666666d * SOLVER_TIMESTEP_SEC;
                d5 += (d8 + ((d10 + d12) * 2.0d) + (((this.mEndValue - d6) * d2) - (d3 * d7))) * 0.16666666666666666d * SOLVER_TIMESTEP_SEC;
            }
            this.mTempState.position = d6;
            this.mTempState.velocity = d7;
            this.mCurrentState.position = d4;
            this.mCurrentState.velocity = d5;
            if (this.mTimeAccumulator > 0.0d) {
                interpolate(this.mTimeAccumulator / SOLVER_TIMESTEP_SEC);
            }
            if (isAtRest() || (this.mOvershootClampingEnabled && isOvershooting())) {
                if (d2 > 0.0d) {
                    this.mStartValue = this.mEndValue;
                    this.mCurrentState.position = this.mEndValue;
                } else {
                    this.mEndValue = this.mCurrentState.position;
                    this.mStartValue = this.mEndValue;
                }
                setVelocity(0.0d);
                z = true;
            } else {
                z = isAtRest;
            }
            if (!this.mWasAtRest) {
                z2 = false;
            } else {
                this.mWasAtRest = false;
                z2 = true;
            }
            boolean z3 = false;
            if (z) {
                this.mWasAtRest = true;
                z3 = true;
            }
            Iterator<SpringListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                SpringListener next = it.next();
                if (z2) {
                    next.onSpringActivate(this);
                }
                next.onSpringUpdate(this);
                if (z3) {
                    next.onSpringAtRest(this);
                }
            }
        }
    }

    public boolean systemShouldAdvance() {
        return (isAtRest() && wasAtRest()) ? false : true;
    }

    public boolean wasAtRest() {
        return this.mWasAtRest;
    }

    public boolean isAtRest() {
        return Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold && (getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold || this.mSpringConfig.tension == 0.0d);
    }

    public Spring setAtRest() {
        this.mEndValue = this.mCurrentState.position;
        this.mTempState.position = this.mCurrentState.position;
        this.mCurrentState.velocity = 0.0d;
        return this;
    }

    private void interpolate(double d) {
        this.mCurrentState.position = (this.mCurrentState.position * d) + (this.mPreviousState.position * (1.0d - d));
        this.mCurrentState.velocity = (this.mCurrentState.velocity * d) + (this.mPreviousState.velocity * (1.0d - d));
    }

    public Spring addListener(SpringListener springListener) {
        if (springListener == null) {
            throw new IllegalArgumentException("newListener is required");
        }
        this.mListeners.add(springListener);
        return this;
    }

    public Spring removeListener(SpringListener springListener) {
        if (springListener == null) {
            throw new IllegalArgumentException("listenerToRemove is required");
        }
        this.mListeners.remove(springListener);
        return this;
    }

    public Spring removeAllListeners() {
        this.mListeners.clear();
        return this;
    }

    public boolean currentValueIsApproximately(double d) {
        return Math.abs(getCurrentValue() - d) <= getRestDisplacementThreshold();
    }
}
