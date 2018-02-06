package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    public DetectorResult detect() throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint correctTopRightRectangular;
        BitMatrix sampleGrid;
        ResultPoint resultPoint2 = null;
        ResultPoint[] detect = this.rectangleDetector.detect();
        ResultPoint resultPoint3 = detect[0];
        ResultPoint resultPoint4 = detect[1];
        ResultPoint resultPoint5 = detect[2];
        ResultPoint resultPoint6 = detect[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint3, resultPoint4));
        arrayList.add(transitionsBetween(resultPoint3, resultPoint5));
        arrayList.add(transitionsBetween(resultPoint4, resultPoint6));
        arrayList.add(transitionsBetween(resultPoint5, resultPoint6));
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        HashMap hashMap = new HashMap();
        increment(hashMap, resultPointsAndTransitions.getFrom());
        increment(hashMap, resultPointsAndTransitions.getTo());
        increment(hashMap, resultPointsAndTransitions2.getFrom());
        increment(hashMap, resultPointsAndTransitions2.getTo());
        ResultPoint resultPoint7 = null;
        ResultPoint resultPoint8 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            ResultPoint resultPoint9 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                resultPoint7 = resultPoint9;
            } else if (resultPoint8 == null) {
                resultPoint8 = resultPoint9;
            } else {
                resultPoint2 = resultPoint9;
            }
        }
        if (resultPoint8 == null || resultPoint7 == null || resultPoint2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint[] resultPointArr = {resultPoint8, resultPoint7, resultPoint2};
        ResultPoint.orderBestPatterns(resultPointArr);
        ResultPoint resultPoint10 = resultPointArr[0];
        ResultPoint resultPoint11 = resultPointArr[1];
        ResultPoint resultPoint12 = resultPointArr[2];
        if (!hashMap.containsKey(resultPoint3)) {
            resultPoint = resultPoint3;
        } else if (hashMap.containsKey(resultPoint4)) {
            resultPoint = !hashMap.containsKey(resultPoint5) ? resultPoint5 : resultPoint6;
        } else {
            resultPoint = resultPoint4;
        }
        int transitions = transitionsBetween(resultPoint12, resultPoint).getTransitions();
        int transitions2 = transitionsBetween(resultPoint10, resultPoint).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        int i = transitions + 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i2 = transitions2 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            correctTopRightRectangular = correctTopRightRectangular(resultPoint11, resultPoint10, resultPoint12, resultPoint, i, i2);
            if (correctTopRightRectangular == null) {
                correctTopRightRectangular = resultPoint;
            }
            int transitions3 = transitionsBetween(resultPoint12, correctTopRightRectangular).getTransitions();
            int transitions4 = transitionsBetween(resultPoint10, correctTopRightRectangular).getTransitions();
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            if ((transitions4 & 1) == 1) {
                transitions4++;
            }
            sampleGrid = sampleGrid(this.image, resultPoint12, resultPoint11, resultPoint10, correctTopRightRectangular, transitions3, transitions4);
        } else {
            correctTopRightRectangular = correctTopRight(resultPoint11, resultPoint10, resultPoint12, resultPoint, Math.min(i2, i));
            if (correctTopRightRectangular == null) {
                correctTopRightRectangular = resultPoint;
            }
            int max = Math.max(transitionsBetween(resultPoint12, correctTopRightRectangular).getTransitions(), transitionsBetween(resultPoint10, correctTopRightRectangular).getTransitions()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            sampleGrid = sampleGrid(this.image, resultPoint12, resultPoint11, resultPoint10, correctTopRightRectangular, max, max);
        }
        return new DetectorResult(sampleGrid, new ResultPoint[]{resultPoint12, resultPoint11, resultPoint10, correctTopRightRectangular});
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) {
        float distance = distance(resultPoint, resultPoint2) / i;
        int distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint((((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance) + resultPoint4.getX(), (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)) + resultPoint4.getY());
        float distance3 = distance(resultPoint, resultPoint3) / i2;
        int distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint((((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3) + resultPoint4.getX(), (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)) + resultPoint4.getY());
        if (isValid(resultPoint5)) {
            return (isValid(resultPoint6) && Math.abs(i - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(i - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
        } else if (!isValid(resultPoint6)) {
            return null;
        } else {
            return resultPoint6;
        }
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float distance = distance(resultPoint, resultPoint2) / i;
        int distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint((((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance) + resultPoint4.getX(), (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)) + resultPoint4.getY());
        float distance3 = distance(resultPoint, resultPoint3) / i;
        int distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint((((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3) + resultPoint4.getX(), (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)) + resultPoint4.getY());
        if (isValid(resultPoint5)) {
            return (isValid(resultPoint6) && Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
        } else if (!isValid(resultPoint6)) {
            return null;
        } else {
            return resultPoint6;
        }
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        map.put(resultPoint, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, i - 0.5f, 0.5f, i - 0.5f, i2 - 0.5f, 0.5f, i2 - 0.5f, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        boolean z = Math.abs(y2 - y) > Math.abs(x2 - x);
        if (!z) {
            y2 = x2;
            x2 = y2;
            y = x;
            x = y;
        }
        int abs = Math.abs(y2 - y);
        int abs2 = Math.abs(x2 - x);
        int i = (-abs) / 2;
        int i2 = x < x2 ? 1 : -1;
        int i3 = y < y2 ? 1 : -1;
        int i4 = 0;
        boolean z2 = this.image.get(z ? x : y, z ? y : x);
        int i5 = x;
        int i6 = i;
        while (y != y2) {
            boolean z3 = this.image.get(z ? i5 : y, z ? y : i5);
            if (z3 != z2) {
                i4++;
                z2 = z3;
            }
            int i7 = i6 + abs2;
            if (i7 > 0) {
                if (i5 == x2) {
                    break;
                }
                i5 += i2;
                i7 -= abs;
            }
            y += i3;
            i6 = i7;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i;
        }

        ResultPoint getFrom() {
            return this.from;
        }

        ResultPoint getTo() {
            return this.to;
        }

        int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + "/" + this.to + '/' + this.transitions;
        }
    }

    /* loaded from: classes3.dex */
    private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }
}
