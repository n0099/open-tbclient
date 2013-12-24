package defpackage;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.common.util.PositionManager;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: n  reason: default package */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        TextView textView;
        SocialShareConfig socialShareConfig;
        Location location;
        Context context;
        Location location2;
        String str2;
        TextView textView2;
        SocialShareConfig socialShareConfig2;
        ImageView imageView;
        z = this.a.e;
        if (z) {
            this.a.e = false;
            textView2 = this.a.d;
            socialShareConfig2 = this.a.h;
            textView2.setText(socialShareConfig2.getString("insert_location"));
            imageView = this.a.c;
            imageView.setVisibility(8);
            return;
        }
        str = this.a.g;
        if (!TextUtils.isEmpty(str)) {
            m mVar = this.a;
            str2 = this.a.g;
            mVar.a(str2);
            return;
        }
        textView = this.a.d;
        socialShareConfig = this.a.h;
        textView.setText(socialShareConfig.getString("get_location"));
        location = this.a.f;
        if (location != null) {
            m mVar2 = this.a;
            location2 = this.a.f;
            mVar2.b(location2);
            return;
        }
        context = this.a.i;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            PositionManager.getInstance(this.a.getContext()).requestLoation(new r(this));
        }
    }
}
