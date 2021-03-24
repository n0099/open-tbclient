package d.b.i0.m3;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.BdTopToast;
/* loaded from: classes5.dex */
public class a {
    public static boolean a(Activity activity, int i, String str) {
        if (c(i)) {
            d(activity, str);
            return true;
        }
        return false;
    }

    public static String b(View view) {
        if (view == null) {
            return null;
        }
        Object tag = view.getTag();
        if (tag instanceof PostData) {
            PostData postData = (PostData) tag;
            if (postData.s() != null) {
                return postData.s().getUserId();
            }
        }
        return null;
    }

    public static boolean c(int i) {
        return i == 1990059;
    }

    public static void d(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        f((ViewGroup) activity.findViewById(16908290), str, false);
    }

    public static void e(View view, PostData postData) {
        if (view == null) {
            return;
        }
        view.setTag(postData);
    }

    public static void f(ViewGroup viewGroup, String str, boolean z) {
        if (viewGroup == null || TextUtils.isEmpty(str)) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(viewGroup.getContext());
        bdTopToast.i(z);
        bdTopToast.h(str);
        bdTopToast.j(viewGroup);
    }
}
