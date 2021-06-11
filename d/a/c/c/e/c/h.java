package d.a.c.c.e.c;

import android.app.Application;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    public static String B = null;
    public static String C = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f42001a = -100000000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f42002b = (-100000000) - 200;

    /* renamed from: c  reason: collision with root package name */
    public static final int f42003c = (-100000000) - 211;

    /* renamed from: d  reason: collision with root package name */
    public static final int f42004d = (-100000000) - 213;

    /* renamed from: e  reason: collision with root package name */
    public static final int f42005e = (-100000000) - 214;

    /* renamed from: f  reason: collision with root package name */
    public static final int f42006f = (-100000000) - 221;

    /* renamed from: g  reason: collision with root package name */
    public static final int f42007g = (-100000000) - 230;

    /* renamed from: h  reason: collision with root package name */
    public static final int f42008h = (-100000000) - 232;

    /* renamed from: i  reason: collision with root package name */
    public static final int f42009i = (-100000000) - 233;
    public static final int j = (-100000000) - 234;
    public static final int k = (-100000000) - 235;
    public static final int l = (-100000000) - 236;
    public static final int m = (-100000000) - 301;
    public static final int n = (-100000000) - 302;
    public static final int o = (-100000000) - 303;
    public static final int p = (-100000000) - 306;
    public static final int q = (-100000000) - 307;
    public static final int r = (-100000000) + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
    public static final int s = (-100000000) + LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING;
    public static final int t = (-100000000) - 310;
    public static final int u = (-100000000) - 311;
    public static final int v = (-100000000) - 312;
    public static final int w = (-100000000) - 313;
    public static final int x = (-100000000) - 314;
    public static final int y = (-100000000) - 310;
    public static final int z = (-100000000) - 311;
    public static final int A = (-100000000) + ErrorCode.ARGS_ERROR;
    public static int[] D = d.a.c.c.c.f41968a;
    public static ArrayList<BasicNameValuePair> E = null;

    public static String a() {
        return C;
    }

    public static ArrayList<BasicNameValuePair> b() {
        return E;
    }

    public static int[] c() {
        return D;
    }

    public static String d() {
        return B;
    }

    public static void e(String str) {
        C = str;
    }

    public static void f(ArrayList<BasicNameValuePair> arrayList) {
        E = arrayList;
    }

    public static void g(int[] iArr) {
        if (iArr == null) {
            return;
        }
        D = iArr;
    }

    public static void h(String str) {
        B = str;
    }

    public static String i(int i2) {
        int i3 = f42001a - i2;
        Application app = BdBaseApplication.getInst().getApp();
        if (i3 > -300 && i3 <= -200) {
            return app.getString(R.string.im_error_codec);
        }
        return app.getString(R.string.im_error_default);
    }
}
