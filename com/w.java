package com;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ v a;
    final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar, v vVar) {
        this.b = sVar;
        this.a = vVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ImageView imageView;
        t tVar;
        ShareMediaItem shareMediaItem = (ShareMediaItem) compoundButton.getTag();
        if (shareMediaItem != null) {
            if (shareMediaItem.isAuthorized()) {
                if (shareMediaItem.isChecked() != z) {
                    shareMediaItem.setChecked(z);
                    tVar = this.b.a;
                    tVar.onCheckStatusChanged(z, shareMediaItem.getMediaType());
                }
                int c = shareMediaItem.isChecked() ? i.c(this.b.getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString()) : i.c(this.b.getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString() + "_gray");
                imageView = this.a.b;
                imageView.setImageResource(c);
            } else if (shareMediaItem.isAuthorized() || !z) {
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(SocialConstants.PARAM_CLIENT_ID, SocialShare.getInstance(this.b.getContext()).getClientId());
                bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, shareMediaItem.getMediaType().toString());
                Intent intent = new Intent(this.b.getContext(), SocialOAuthActivity.class);
                intent.addFlags(268435456);
                intent.putExtras(bundle);
                SocialOAuthActivity.setListener(new z(this, shareMediaItem));
                this.b.getContext().getApplicationContext().startActivity(intent);
            }
        }
    }
}
