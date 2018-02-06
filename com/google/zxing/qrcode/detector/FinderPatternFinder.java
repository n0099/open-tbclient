package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.image;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        int findRowSkip;
        int i;
        int i2;
        boolean z;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z3 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i3 = ((height * 3) / 228 < 3 || z2) ? 3 : 3;
        boolean z4 = false;
        int[] iArr = new int[5];
        int i4 = i3 - 1;
        int i5 = i3;
        while (i4 < height && !z4) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i6 = 0;
            int i7 = 0;
            while (i7 < width) {
                if (this.image.get(i7, i4)) {
                    if ((i6 & 1) == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if ((i6 & 1) == 0) {
                    if (i6 == 4) {
                        if (foundPatternCross(iArr)) {
                            if (handlePossibleCenter(iArr, i4, i7, z3)) {
                                i5 = 2;
                                if (this.hasSkipped) {
                                    z = haveMultiplyConfirmedCenters();
                                } else {
                                    if (findRowSkip() > iArr[2]) {
                                        i2 = i4 + ((findRowSkip - iArr[2]) - 2);
                                        i = width - 1;
                                    } else {
                                        i = i7;
                                        i2 = i4;
                                    }
                                    i4 = i2;
                                    i7 = i;
                                    z = z4;
                                }
                                iArr[0] = 0;
                                iArr[1] = 0;
                                iArr[2] = 0;
                                iArr[3] = 0;
                                iArr[4] = 0;
                                z4 = z;
                                i6 = 0;
                            } else {
                                iArr[0] = iArr[2];
                                iArr[1] = iArr[3];
                                iArr[2] = iArr[4];
                                iArr[3] = 1;
                                iArr[4] = 0;
                                i6 = 3;
                            }
                        } else {
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = iArr[4];
                            iArr[3] = 1;
                            iArr[4] = 0;
                            i6 = 3;
                        }
                    } else {
                        i6++;
                        iArr[i6] = iArr[i6] + 1;
                    }
                } else {
                    iArr[i6] = iArr[i6] + 1;
                }
                i7++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i4, width, z3)) {
                i5 = iArr[0];
                if (this.hasSkipped) {
                    z4 = haveMultiplyConfirmedCenters();
                }
            }
            i4 += i5;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i >= 7) {
            float f = i / 7.0f;
            float f2 = f / 2.0f;
            return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((3.0f * f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
        }
        return false;
    }

    private int[] getCrossCheckStateCount() {
        this.crossCheckStateCount[0] = 0;
        this.crossCheckStateCount[1] = 0;
        this.crossCheckStateCount[2] = 0;
        this.crossCheckStateCount[3] = 0;
        this.crossCheckStateCount[4] = 0;
        return this.crossCheckStateCount;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r8 < r0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r9 < r0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r7.image.get(r9 - r0, r8 - r0) != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r1[1] > r10) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
        r1[1] = r1[1] + 1;
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r8 < r0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r9 < r0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r1[1] <= r10) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
        if (r8 < r0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
        if (r9 < r0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (r7.image.get(r9 - r0, r8 - r0) == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
        if (r1[0] > r10) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
        r1[0] = r1[0] + 1;
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
        if (r1[0] <= r10) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
        r2 = r7.image.getHeight();
        r3 = r7.image.getWidth();
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        if ((r8 + r0) >= r2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
        if ((r9 + r0) >= r3) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
        if (r7.image.get(r9 + r0, r8 + r0) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
        r1[2] = r1[2] + 1;
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a2, code lost:
        if ((r8 + r0) >= r2) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:
        if ((r9 + r0) < r3) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a8, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ad, code lost:
        if ((r8 + r0) >= r2) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b1, code lost:
        if ((r9 + r0) >= r3) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bd, code lost:
        if (r7.image.get(r9 + r0, r8 + r0) != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c2, code lost:
        if (r1[3] >= r10) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c4, code lost:
        r1[3] = r1[3] + 1;
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d0, code lost:
        if ((r8 + r0) >= r2) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d4, code lost:
        if ((r9 + r0) >= r3) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d9, code lost:
        if (r1[3] < r10) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00db, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e0, code lost:
        if ((r8 + r0) >= r2) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e4, code lost:
        if ((r9 + r0) >= r3) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f0, code lost:
        if (r7.image.get(r9 + r0, r8 + r0) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f5, code lost:
        if (r1[4] >= r10) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f7, code lost:
        r1[4] = r1[4] + 1;
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0104, code lost:
        if (r1[4] < r10) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0106, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0123, code lost:
        if (java.lang.Math.abs(((((r1[0] + r1[1]) + r1[2]) + r1[3]) + r1[4]) - r11) >= (r11 * 2)) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0129, code lost:
        if (foundPatternCross(r1) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012b, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012e, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r9 >= r0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean crossCheckDiagonal(int i, int i2, int i3, int i4) {
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = 0;
        while (i >= i5 && i2 >= i5 && this.image.get(i2 - i5, i - i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5++;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r4[1] > r14) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r1 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r2.get(r13, r1) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r4[0] > r14) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (r4[0] > r14) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        r1 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
        if (r1 >= r3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
        if (r2.get(r13, r1) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006e, code lost:
        if (r1 == r3) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0070, code lost:
        if (r1 >= r3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
        if (r2.get(r13, r1) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
        if (r4[3] >= r14) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
        r4[3] = r4[3] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
        if (r1 == r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0089, code lost:
        if (r4[3] >= r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008b, code lost:
        if (r1 >= r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
        if (r2.get(r13, r1) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
        if (r4[4] >= r14) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
        r4[4] = r4[4] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a2, code lost:
        if (r4[4] >= r14) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bc, code lost:
        if ((java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r15) * 5) >= (r15 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c2, code lost:
        if (foundPatternCross(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
        return centerFromEnd(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r4[1] > r14) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r1 < 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r2.get(r1, r13) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r4[0] > r14) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        r4[0] = r4[0] + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (r4[0] > r14) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
        r1 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
        if (r1 >= r3) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
        if (r2.get(r1, r13) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
        r4[2] = r4[2] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006e, code lost:
        if (r1 == r3) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0070, code lost:
        if (r1 >= r3) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
        if (r2.get(r1, r13) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
        if (r4[3] >= r14) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
        r4[3] = r4[3] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
        if (r1 == r3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0089, code lost:
        if (r4[3] >= r14) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008b, code lost:
        if (r1 >= r3) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
        if (r2.get(r1, r13) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
        if (r4[4] >= r14) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
        r4[4] = r4[4] + 1;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a2, code lost:
        if (r4[4] >= r14) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ba, code lost:
        if ((java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r15) * 5) >= r15) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c0, code lost:
        if (foundPatternCross(r4) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
        return centerFromEnd(r4, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        return Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float centerFromEnd = centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, (int) centerFromEnd, iArr[2], i3);
        if (Float.isNaN(crossCheckVertical)) {
            return false;
        }
        float crossCheckHorizontal = crossCheckHorizontal((int) centerFromEnd, (int) crossCheckVertical, iArr[2], i3);
        if (Float.isNaN(crossCheckHorizontal)) {
            return false;
        }
        if (!z || crossCheckDiagonal((int) crossCheckVertical, (int) crossCheckHorizontal, iArr[2], i3)) {
            float f = i3 / 7.0f;
            int i4 = 0;
            while (true) {
                if (i4 >= this.possibleCenters.size()) {
                    break;
                }
                FinderPattern finderPattern = this.possibleCenters.get(i4);
                if (!finderPattern.aboutEquals(f, crossCheckVertical, crossCheckHorizontal)) {
                    i4++;
                } else {
                    this.possibleCenters.set(i4, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f));
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f);
                this.possibleCenters.add(finderPattern2);
                if (this.resultPointCallback != null) {
                    this.resultPointCallback.foundPossibleResultPoint(finderPattern2);
                }
            }
            return true;
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        float f;
        float f2 = 0.0f;
        int size = this.possibleCenters.size();
        float f3 = 0.0f;
        int i = 0;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i++;
                f = finderPattern.getEstimatedModuleSize() + f3;
            } else {
                f = f3;
            }
            i = i;
            f3 = f;
        }
        if (i < 3) {
            return false;
        }
        float f4 = f3 / size;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            f2 += Math.abs(finderPattern2.getEstimatedModuleSize() - f4);
        }
        return f2 <= 0.05f * f3;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        float f = 0.0f;
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size > 3) {
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (FinderPattern finderPattern : this.possibleCenters) {
                float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
                f3 += estimatedModuleSize;
                f2 = (estimatedModuleSize * estimatedModuleSize) + f2;
            }
            float f4 = f3 / size;
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f4));
            float max = Math.max(0.2f * f4, (float) Math.sqrt((f2 / size) - (f4 * f4)));
            int i = 0;
            while (i < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                if (Math.abs(this.possibleCenters.get(i).getEstimatedModuleSize() - f4) > max) {
                    this.possibleCenters.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            for (FinderPattern finderPattern2 : this.possibleCenters) {
                f += finderPattern2.getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(f / this.possibleCenters.size()));
            this.possibleCenters.subList(3, this.possibleCenters.size()).clear();
        }
        return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() == finderPattern.getCount()) {
                float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
                float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
                if (abs < abs2) {
                    return 1;
                }
                return abs == abs2 ? 0 : -1;
            }
            return finderPattern2.getCount() - finderPattern.getCount();
        }
    }
}
