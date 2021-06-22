package d.a.h.b.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.webkit.internal.utils.UtilsBlink;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f43725a = !a.class.desiredAssertionStatus();

    /* renamed from: d.a.h.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0598a {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f43726a;

        /* renamed from: b  reason: collision with root package name */
        public int f43727b;
    }

    /* loaded from: classes.dex */
    public static class b extends AbstractC0598a {

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f43728c;

        /* renamed from: d  reason: collision with root package name */
        public int f43729d;

        /* renamed from: e  reason: collision with root package name */
        public int f43730e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f43731f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f43732g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f43733h;

        /* renamed from: i  reason: collision with root package name */
        public final byte[] f43734i;
        public static final /* synthetic */ boolean k = !a.class.desiredAssertionStatus();
        public static final byte[] j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};

        public b() {
            this.f43726a = null;
            this.f43731f = false;
            this.f43732g = false;
            this.f43733h = false;
            this.f43734i = j;
            this.f43728c = new byte[2];
            this.f43729d = 0;
            this.f43730e = 0 != 0 ? 19 : -1;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x010c -> B:39:0x00b9). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] r18) {
        /*
            r0 = r18
            int r1 = r0.length
            d.a.h.b.c.a$b r2 = new d.a.h.b.c.a$b
            r2.<init>()
            int r3 = r1 / 3
            r4 = 4
            int r3 = r3 * 4
            boolean r5 = r2.f43731f
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L1a
            int r5 = r1 % 3
            if (r5 <= 0) goto L26
            int r3 = r3 + 4
            goto L26
        L1a:
            int r5 = r1 % 3
            if (r5 == r7) goto L24
            if (r5 == r6) goto L21
            goto L26
        L21:
            int r3 = r3 + 3
            goto L26
        L24:
            int r3 = r3 + 2
        L26:
            boolean r5 = r2.f43732g
            if (r5 == 0) goto L3b
            if (r1 <= 0) goto L3b
            int r5 = r1 + (-1)
            int r5 = r5 / 57
            int r5 = r5 + r7
            boolean r8 = r2.f43733h
            if (r8 == 0) goto L37
            r8 = 2
            goto L38
        L37:
            r8 = 1
        L38:
            int r5 = r5 * r8
            int r3 = r3 + r5
        L3b:
            byte[] r5 = new byte[r3]
            r2.f43726a = r5
            byte[] r8 = r2.f43734i
            int r9 = r2.f43730e
            r10 = 0
            int r1 = r1 + r10
            int r11 = r2.f43729d
            r12 = -1
            if (r11 == r7) goto L67
            if (r11 == r6) goto L4d
            goto L81
        L4d:
            if (r1 <= 0) goto L81
            byte[] r11 = r2.f43728c
            r13 = r11[r10]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 16
            r11 = r11[r7]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r11 = r11 | r13
            r13 = r0[r10]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r2.f43729d = r10
            r13 = 1
            goto L83
        L67:
            if (r6 > r1) goto L81
            byte[] r11 = r2.f43728c
            r11 = r11[r10]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 16
            r13 = r0[r10]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 8
            r11 = r11 | r13
            r13 = r0[r7]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r2.f43729d = r10
            r13 = 2
            goto L83
        L81:
            r11 = -1
            r13 = 0
        L83:
            r15 = 13
            r16 = 10
            if (r11 == r12) goto Lbe
            int r12 = r11 >> 18
            r12 = r12 & 63
            r12 = r8[r12]
            r5[r10] = r12
            int r12 = r11 >> 12
            r12 = r12 & 63
            r12 = r8[r12]
            r5[r7] = r12
            int r12 = r11 >> 6
            r12 = r12 & 63
            r12 = r8[r12]
            r5[r6] = r12
            r11 = r11 & 63
            r11 = r8[r11]
            r12 = 3
            r5[r12] = r11
            int r9 = r9 + (-1)
            if (r9 != 0) goto Lbc
            boolean r9 = r2.f43733h
            if (r9 == 0) goto Lb4
            r9 = 5
            r5[r4] = r15
            goto Lb5
        Lb4:
            r9 = 4
        Lb5:
            int r11 = r9 + 1
            r5[r9] = r16
        Lb9:
            r9 = 19
            goto Lbf
        Lbc:
            r11 = 4
            goto Lbf
        Lbe:
            r11 = 0
        Lbf:
            int r12 = r13 + 3
            if (r12 > r1) goto L117
            r14 = r0[r13]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << 16
            int r17 = r13 + 1
            r6 = r0[r17]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            r6 = r6 | r14
            int r13 = r13 + 2
            r13 = r0[r13]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r6 = r6 | r13
            int r13 = r6 >> 18
            r13 = r13 & 63
            r13 = r8[r13]
            r5[r11] = r13
            int r13 = r11 + 1
            int r14 = r6 >> 12
            r14 = r14 & 63
            r14 = r8[r14]
            r5[r13] = r14
            int r13 = r11 + 2
            int r14 = r6 >> 6
            r14 = r14 & 63
            r14 = r8[r14]
            r5[r13] = r14
            int r13 = r11 + 3
            r6 = r6 & 63
            r6 = r8[r6]
            r5[r13] = r6
            int r11 = r11 + 4
            int r9 = r9 + (-1)
            if (r9 != 0) goto L114
            boolean r6 = r2.f43733h
            if (r6 == 0) goto L10c
            int r6 = r11 + 1
            r5[r11] = r15
            r11 = r6
        L10c:
            int r6 = r11 + 1
            r5[r11] = r16
            r11 = r6
            r13 = r12
            r6 = 2
            goto Lb9
        L114:
            r13 = r12
            r6 = 2
            goto Lbf
        L117:
            int r6 = r2.f43729d
            int r12 = r13 - r6
            int r14 = r1 + (-1)
            r17 = 61
            if (r12 != r14) goto L16a
            if (r6 <= 0) goto L128
            byte[] r0 = r2.f43728c
            r0 = r0[r10]
            goto L12e
        L128:
            int r6 = r13 + 1
            r0 = r0[r13]
            r13 = r6
            r7 = 0
        L12e:
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << r4
            int r4 = r2.f43729d
            int r4 = r4 - r7
            r2.f43729d = r4
            int r4 = r11 + 1
            int r6 = r0 >> 6
            r6 = r6 & 63
            r6 = r8[r6]
            r5[r11] = r6
            int r6 = r4 + 1
            r0 = r0 & 63
            r0 = r8[r0]
            r5[r4] = r0
            boolean r0 = r2.f43731f
            if (r0 == 0) goto L154
            int r0 = r6 + 1
            r5[r6] = r17
            int r6 = r0 + 1
            r5[r0] = r17
        L154:
            boolean r0 = r2.f43732g
            if (r0 == 0) goto L167
            boolean r0 = r2.f43733h
            if (r0 == 0) goto L161
            int r0 = r6 + 1
            r5[r6] = r15
            r6 = r0
        L161:
            int r0 = r6 + 1
            r5[r6] = r16
            goto L1ed
        L167:
            r11 = r6
            goto L1ee
        L16a:
            int r4 = r13 - r6
            int r12 = r1 + (-2)
            if (r4 != r12) goto L1d6
            if (r6 <= r7) goto L177
            byte[] r4 = r2.f43728c
            r4 = r4[r10]
            goto L17e
        L177:
            int r4 = r13 + 1
            r6 = r0[r13]
            r13 = r4
            r4 = r6
            r7 = 0
        L17e:
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << 10
            int r6 = r2.f43729d
            if (r6 <= 0) goto L18e
            byte[] r0 = r2.f43728c
            int r6 = r7 + 1
            r0 = r0[r7]
            r7 = r6
            goto L193
        L18e:
            int r6 = r13 + 1
            r0 = r0[r13]
            r13 = r6
        L193:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r6 = 2
            int r0 = r0 << r6
            r0 = r0 | r4
            int r4 = r2.f43729d
            int r4 = r4 - r7
            r2.f43729d = r4
            int r4 = r11 + 1
            int r6 = r0 >> 12
            r6 = r6 & 63
            r6 = r8[r6]
            r5[r11] = r6
            int r6 = r4 + 1
            int r7 = r0 >> 6
            r7 = r7 & 63
            r7 = r8[r7]
            r5[r4] = r7
            int r4 = r6 + 1
            r0 = r0 & 63
            r0 = r8[r0]
            r5[r6] = r0
            boolean r0 = r2.f43731f
            if (r0 == 0) goto L1c2
            int r0 = r4 + 1
            r5[r4] = r17
            r4 = r0
        L1c2:
            boolean r0 = r2.f43732g
            if (r0 == 0) goto L1d4
            boolean r0 = r2.f43733h
            if (r0 == 0) goto L1cf
            int r0 = r4 + 1
            r5[r4] = r15
            r4 = r0
        L1cf:
            int r0 = r4 + 1
            r5[r4] = r16
            goto L1ed
        L1d4:
            r11 = r4
            goto L1ee
        L1d6:
            boolean r0 = r2.f43732g
            if (r0 == 0) goto L1ee
            if (r11 <= 0) goto L1ee
            r0 = 19
            if (r9 == r0) goto L1ee
            boolean r0 = r2.f43733h
            if (r0 == 0) goto L1e9
            int r0 = r11 + 1
            r5[r11] = r15
            r11 = r0
        L1e9:
            int r0 = r11 + 1
            r5[r11] = r16
        L1ed:
            r11 = r0
        L1ee:
            boolean r0 = d.a.h.b.c.a.b.k
            if (r0 != 0) goto L1fd
            int r0 = r2.f43729d
            if (r0 != 0) goto L1f7
            goto L1fd
        L1f7:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L1fd:
            boolean r0 = d.a.h.b.c.a.b.k
            if (r0 != 0) goto L20a
            if (r13 != r1) goto L204
            goto L20a
        L204:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L20a:
            r2.f43727b = r11
            r2.f43730e = r9
            boolean r0 = d.a.h.b.c.a.f43725a
            if (r0 != 0) goto L21b
            if (r11 != r3) goto L215
            goto L21b
        L215:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L21b:
            byte[] r0 = r2.f43726a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.h.b.c.a.a(byte[]):byte[]");
    }
}
