package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;
/* loaded from: classes.dex */
public class MAlarmHandler {
    public static final long NEXT_FIRE_INTERVAL = Long.MAX_VALUE;
    private static IBumper aC;
    private static int av;
    private final CallBack aB;
    private final int aw;
    private final boolean ax;
    private long ay = 0;
    private long az = 0;
    private static Map<Integer, MAlarmHandler> aA = new HashMap();
    private static boolean aD = false;

    /* loaded from: classes.dex */
    public interface CallBack {
        boolean onTimerExpired();
    }

    /* loaded from: classes.dex */
    public interface IBumper {
        void cancel();

        void prepare();
    }

    public MAlarmHandler(CallBack callBack, boolean z) {
        Assert.assertTrue("bumper not initialized", aD);
        this.aB = callBack;
        this.ax = z;
        if (av >= 8192) {
            av = 0;
        }
        int i = av + 1;
        av = i;
        this.aw = i;
    }

    public static long fire() {
        LinkedList linkedList = new LinkedList();
        HashSet<Integer> hashSet = new HashSet();
        hashSet.addAll(aA.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            MAlarmHandler mAlarmHandler = aA.get(num);
            if (mAlarmHandler != null) {
                long ticksToNow = Util.ticksToNow(mAlarmHandler.ay);
                if (ticksToNow < 0) {
                    ticksToNow = 0;
                }
                if (ticksToNow > mAlarmHandler.az) {
                    if (mAlarmHandler.aB.onTimerExpired() && mAlarmHandler.ax) {
                        j = mAlarmHandler.az;
                    } else {
                        linkedList.add(num);
                    }
                    mAlarmHandler.ay = Util.currentTicks();
                } else if (mAlarmHandler.az - ticksToNow < j) {
                    j = mAlarmHandler.az - ticksToNow;
                }
            }
            j = j;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            aA.remove(linkedList.get(i));
        }
        if (j == Long.MAX_VALUE && aC != null) {
            aC.cancel();
            Log.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        return j;
    }

    public static void initAlarmBumper(IBumper iBumper) {
        aD = true;
        aC = iBumper;
    }

    protected void finalize() {
        stopTimer();
        super.finalize();
    }

    public void startTimer(long j) {
        long j2;
        this.az = j;
        this.ay = Util.currentTicks();
        long j3 = this.az;
        Log.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + j3);
        long j4 = Long.MAX_VALUE;
        Iterator<Map.Entry<Integer, MAlarmHandler>> it = aA.entrySet().iterator();
        while (true) {
            j2 = j4;
            if (!it.hasNext()) {
                break;
            }
            MAlarmHandler value = it.next().getValue();
            if (value != null) {
                long ticksToNow = Util.ticksToNow(value.ay);
                if (ticksToNow < 0) {
                    ticksToNow = 0;
                }
                if (ticksToNow > value.az) {
                    j4 = value.az;
                } else if (value.az - ticksToNow < j2) {
                    j2 = value.az - ticksToNow;
                }
            }
            j4 = j2;
        }
        boolean z = j2 > j3;
        stopTimer();
        aA.put(Integer.valueOf(this.aw), this);
        if (aC == null || !z) {
            return;
        }
        Log.v("MicroMsg.MAlarmHandler", "prepare bumper");
        aC.prepare();
    }

    public void stopTimer() {
        aA.remove(Integer.valueOf(this.aw));
    }

    public boolean stopped() {
        return !aA.containsKey(Integer.valueOf(this.aw));
    }
}
