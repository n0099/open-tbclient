package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.ui.MediaIconManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: an  reason: default package */
/* loaded from: classes.dex */
public class an implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ at f269a;
    final /* synthetic */ MediaIconManager b;
    final /* synthetic */ String c;
    final /* synthetic */ ImageView d;
    final /* synthetic */ Context e;
    final /* synthetic */ ba f;
    final /* synthetic */ af g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(af afVar, at atVar, MediaIconManager mediaIconManager, String str, ImageView imageView, Context context, ba baVar) {
        this.g = afVar;
        this.f269a = atVar;
        this.b = mediaIconManager;
        this.c = str;
        this.d = imageView;
        this.e = context;
        this.f = baVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        aj ajVar;
        if (this.f269a.d()) {
            this.f269a.a(z);
            this.d.setImageDrawable(this.f269a.c() ? this.b.getNormalIcon(this.c) : this.b.getDisabledIcon(this.c));
            if (this.f269a.a() == MediaType.QZONE) {
                ajVar = this.g.f265a;
                ajVar.onCheckStatusChanged(z);
            }
        } else if (this.f269a.d() || !z) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(SocialConstants.PARAM_CLIENT_ID, SocialShare.getInstance(this.g.getContext()).getClientId());
            bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, this.c);
            Intent intent = new Intent(this.e, SocialOAuthActivity.class);
            intent.putExtras(bundle);
            SocialOAuthActivity.setListener(new ar(this));
            this.e.startActivity(intent);
        }
    }
}
