package com.yy.sdk.crashreportbaidu;

import com.baidu.tieba.jgc;
import com.baidu.tieba.mgc;
import java.util.Collections;
/* loaded from: classes2.dex */
public class CrashInfo extends ReportInfo {

    /* loaded from: classes2.dex */
    public enum CrashType {
        CrashTypeJava(0),
        CrashTypeNative(1);
        
        public int mValue;

        public int getValue() {
            return this.mValue;
        }

        CrashType(int i) {
            this.mValue = i;
        }

        public static String toString(int i) {
            return toString(valueOf(i));
        }

        public static CrashType valueOf(int i) {
            if (i != 0) {
                if (i != 1) {
                    return CrashTypeJava;
                }
                return CrashTypeNative;
            }
            return CrashTypeJava;
        }

        public static String toString(CrashType crashType) {
            if (a.a[crashType.ordinal()] != 1) {
                return "JAVA_CRASH";
            }
            return "NATIVE_CRASH";
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CrashType.values().length];
            a = iArr;
            try {
                iArr[CrashType.CrashTypeNative.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static CrashInfo generateCrashInfo(CrashType crashType, String... strArr) {
        CrashInfo crashInfo = new CrashInfo();
        crashInfo.crashId = mgc.n();
        crashInfo.history = ActivityHistory.INSTANCE.getHistory();
        crashInfo.crashType = CrashType.toString(crashType);
        Collections.addAll(crashInfo.fileList, strArr);
        crashInfo.nyyData = mgc.x(crashInfo);
        jgc.d("CrashReport", "generateCrashInfo finished!");
        return crashInfo;
    }
}
