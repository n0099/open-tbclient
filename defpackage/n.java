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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f2834a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f2834a = mVar;
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
        z = this.f2834a.e;
        if (z) {
            this.f2834a.e = false;
            textView2 = this.f2834a.d;
            socialShareConfig2 = this.f2834a.h;
            textView2.setText(socialShareConfig2.getString("insert_location"));
            imageView = this.f2834a.c;
            imageView.setVisibility(8);
            return;
        }
        str = this.f2834a.g;
        if (!TextUtils.isEmpty(str)) {
            m mVar = this.f2834a;
            str2 = this.f2834a.g;
            mVar.a(str2);
            return;
        }
        textView = this.f2834a.d;
        socialShareConfig = this.f2834a.h;
        textView.setText(socialShareConfig.getString("get_location"));
        location = this.f2834a.f;
        if (location != null) {
            m mVar2 = this.f2834a;
            location2 = this.f2834a.f;
            mVar2.b(location2);
            return;
        }
        context = this.f2834a.i;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            PositionManager.getInstance(this.f2834a.getContext()).requestLoation(new r(this));
        }
    }
}
