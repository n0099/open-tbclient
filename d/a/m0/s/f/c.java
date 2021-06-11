package d.a.m0.s.f;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f54341a = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Arrays.asList(f54341a).contains(str);
    }
}
