package com.yy.mediaframework.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoStatisticTool {
    public static final int TIME = 60;
    private int mCounter = 0;
    private long mCurrentTime = 0;
    private int max = -1;
    private int min = -1;
    private int sum = 0;
    private long mLastTime = 0;
    private boolean isDebug = false;
    private boolean isStallingMode = false;
    private long mCurSample = 0;
    private long mLastSample = 0;
    private List<Integer> mCountList = new ArrayList();
    private List<Integer> mAverageList = new ArrayList();
    private List<Integer> mMaxList = new ArrayList();
    private List<Integer> mMinList = new ArrayList();
    private List<Integer> mSumList = new ArrayList();
    private VideoStatisticResult mResult = new VideoStatisticResult();

    public synchronized void triggerStatistic(int i) {
        if (this.min == -1 && this.max == -1) {
            this.min = i;
            this.max = i;
        }
        this.mCounter++;
        this.max = this.max < i ? i : this.max;
        this.min = this.min < i ? this.min : i;
        this.sum += i;
    }

    public synchronized void triggerStatistic() {
        this.mCurrentTime = System.currentTimeMillis();
        this.mCurSample = System.currentTimeMillis();
        if (this.mLastTime == 0 || this.mLastSample == 0) {
            this.mLastSample = System.currentTimeMillis();
            this.mLastTime = System.currentTimeMillis();
        } else {
            int i = (int) (this.mCurSample - this.mLastSample);
            if (this.min == -1 && this.max == -1) {
                this.min = i;
                this.max = i;
            }
            this.mCounter++;
            this.max = this.max < i ? i : this.max;
            this.min = this.min < i ? this.min : i;
            this.sum += i;
            if (this.mCurrentTime - this.mLastTime >= 1000) {
                this.mCountList.add(Integer.valueOf(this.mCounter));
                this.mAverageList.add(Integer.valueOf(this.sum / this.mCounter));
                this.mMaxList.add(Integer.valueOf(this.max));
                this.mMinList.add(Integer.valueOf(this.min));
                this.mSumList.add(Integer.valueOf(this.sum));
                this.mLastTime = this.mCurrentTime;
                this.mLastSample = this.mCurSample;
                this.mCounter = 0;
                this.max = -1;
                this.sum = 0;
                this.min = -1;
            } else {
                this.mLastSample = this.mCurSample;
            }
        }
    }

    public synchronized void triggerStatisticCalcBySecond(int i) {
        this.mCurrentTime = System.currentTimeMillis();
        if (this.mLastTime == 0) {
            this.mLastTime = System.currentTimeMillis();
        } else {
            if (this.min == -1 && this.max == -1) {
                this.min = i;
                this.max = i;
            }
            this.mCounter++;
            this.max = this.max < i ? i : this.max;
            this.min = this.min < i ? this.min : i;
            this.sum += i;
            if (this.mCurrentTime - this.mLastTime >= 1000) {
                this.mCountList.add(Integer.valueOf(this.mCounter));
                this.mAverageList.add(Integer.valueOf(this.sum / this.mCounter));
                this.mMaxList.add(Integer.valueOf(this.max));
                this.mMinList.add(Integer.valueOf(this.min));
                this.mSumList.add(Integer.valueOf(this.sum));
                this.mCounter = 0;
                this.mLastTime = this.mCurrentTime;
                this.max = -1;
                this.sum = 0;
                this.min = -1;
            }
        }
    }

    public synchronized void triggerStatisticCalcStalling(int i) {
        this.isStallingMode = true;
        this.mCurrentTime = System.currentTimeMillis();
        if (this.mLastTime == 0) {
            this.mLastTime = System.currentTimeMillis();
        } else {
            if (this.min == -1 && this.max == -1) {
                this.min = i;
                this.max = i;
            }
            this.mCounter++;
            this.max = this.max < i ? i : this.max;
            this.min = this.min < i ? this.min : i;
            this.sum += i;
            if (this.mCurrentTime - this.mLastTime >= 1000) {
                this.mCountList.add(Integer.valueOf(this.mCounter));
                this.mAverageList.add(Integer.valueOf(this.sum / this.mCounter));
                this.mMaxList.add(Integer.valueOf(this.max));
                this.mMinList.add(Integer.valueOf(this.min));
                this.mSumList.add(Integer.valueOf(this.sum));
                this.mCounter = 0;
                this.mLastTime = this.mCurrentTime;
                this.max = -1;
                this.sum = 0;
                this.min = -1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class VideoStatisticResult {
        public boolean isValid = false;
        public int minDeal = -1;
        public int maxDeal = -1;
        public int meanDeal = -1;
        public int meanCount = 0;
        public int sumDeal = 0;
        public int other = -1;

        public VideoStatisticResult() {
        }
    }

    public synchronized VideoStatisticResult getStatisticResult() {
        return this.mResult;
    }

    private void printListInfo(List<Integer> list, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
        if (list != null) {
            String str = " ";
            for (int i = 0; i < list.size(); i++) {
                str = str + list.get(i) + ":" + list2.get(i) + ":" + list3.get(i) + ":" + list4.get(i) + ", ";
            }
            YMFLog.info(this, "[CCapture]", "listInfo:[" + str + "]");
        }
    }

    /* loaded from: classes6.dex */
    public static class StallingModel {
        private static final float alpha = 0.999f;
        private static final float k = 3.5E-4f;
        private static final int threshold = 500;

        public static int maxOut(int i, int i2) {
            if (i >= i2) {
                return i;
            }
            return 0;
        }

        public static int sum(List<Integer> list) {
            int i = 0;
            Iterator<Integer> it = list.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    i = it.next().intValue() + i2;
                } else {
                    return i2;
                }
            }
        }

        public static void filterGte1sData(List<Integer> list, List<Integer> list2) {
            for (Integer num : list) {
                int intValue = num.intValue();
                if (maxOut(intValue, 1000) > 0) {
                    list2.add(Integer.valueOf(intValue));
                }
            }
        }

        public static void filterStallingData(List<Integer> list, List<Integer> list2) {
            for (Integer num : list) {
                int intValue = num.intValue();
                if (maxOut(intValue, 500) > 0) {
                    list2.add(Integer.valueOf(intValue));
                }
            }
        }

        public static int calcStallingRate(List<Integer> list) {
            if (list == null || list.size() <= 0) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            double d = 0.0d;
            double size = list.size();
            filterStallingData(list, arrayList);
            filterGte1sData(list, arrayList2);
            double sum = sum(arrayList);
            double size2 = arrayList.size();
            if (arrayList2 != null) {
                d = ((size - arrayList2.size()) * 1000.0d) + sum(arrayList2);
            }
            return (int) ((1.0d - Math.exp((((sum * 0.9990000128746033d) / d) + ((9.999871253967285E-4d * size2) / size)) * (((-3.499999875202775E-4d) * size2) * sum))) * 100.0d);
        }
    }

    public synchronized void flush() {
        this.mResult.meanDeal = -1;
        this.mResult.maxDeal = this.max;
        this.mResult.minDeal = this.min;
        this.mResult.meanCount = this.mCounter;
        if (this.mCounter > 0) {
            this.mResult.meanDeal = this.sum / this.mCounter;
        }
        this.max = -1;
        this.min = -1;
        this.sum = 0;
        this.mCounter = 0;
        if (this.mAverageList != null && this.mAverageList.size() > 0) {
            this.mResult.meanDeal = CommonUtil.calcListMean(this.mAverageList);
            this.mAverageList.clear();
        }
        if (this.mMaxList != null && this.mMaxList.size() > 0) {
            this.mResult.maxDeal = CommonUtil.calcListMax(this.mMaxList);
            if (this.isStallingMode) {
                this.mResult.other = StallingModel.calcStallingRate(this.mMaxList);
                if (this.mResult.other > 0) {
                    YMFLog.info(this, "[CCapture]", "mResult.other:" + this.mResult.other + "MaxListInfo:" + this.mMaxList);
                }
            }
            this.mMaxList.clear();
        }
        if (this.mMinList != null && this.mMinList.size() > 0) {
            this.mResult.minDeal = CommonUtil.calcListMin(this.mMinList);
            this.mMinList.clear();
        }
        if (this.mCountList != null && this.mCountList.size() > 0) {
            this.mResult.meanCount = CommonUtil.calcListMean(this.mCountList);
            this.mCountList.clear();
        }
        if (this.mSumList != null && this.mSumList.size() > 0) {
            this.mResult.sumDeal = CommonUtil.calcListSum(this.mSumList);
            this.mSumList.clear();
        }
    }
}
