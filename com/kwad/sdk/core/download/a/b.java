package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import java.util.List;
/* loaded from: classes10.dex */
public final class b {

    /* loaded from: classes10.dex */
    public interface a {
        void oe();

        void onError(Throwable th);

        void onPreStart();

        void onStart();

        void onSuccess();
    }

    /* renamed from: com.kwad.sdk.core.download.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0705b implements a {
        @Override // com.kwad.sdk.core.download.a.b.a
        public final void oe() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onError(Throwable th) {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public final void onPreStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onStart() {
        }

        @Override // com.kwad.sdk.core.download.a.b.a
        public void onSuccess() {
        }
    }

    public static int D(Context context, String str) {
        return a(context, str, new C0705b());
    }

    public static int a(Context context, String str, @NonNull a aVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return 0;
        }
        try {
            aVar.onPreStart();
            com.kwad.sdk.core.e.c.d("DeepLinkUtil", "handleDeepLink: " + str);
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction(IntentConstants.ACTION_BOX_BROWSER);
            intent.setData(parse);
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                aVar.onStart();
                context.startActivity(intent);
                aVar.onSuccess();
                return 1;
            }
            aVar.oe();
            return 0;
        } catch (Throwable th) {
            aVar.onError(th);
            return -1;
        }
    }
}
