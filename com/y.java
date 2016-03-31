package com;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareMediaItem;
import com.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ x.b nk;
    final /* synthetic */ x nl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, x.b bVar) {
        this.nl = xVar;
        this.nk = bVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        x.a aVar;
        ShareMediaItem shareMediaItem = (ShareMediaItem) compoundButton.getTag();
        if (shareMediaItem != null) {
            if (shareMediaItem.isAuthorized()) {
                if (shareMediaItem.isChecked() != z) {
                    shareMediaItem.setChecked(z);
                    aVar = this.nl.nh;
                    aVar.onCheckStatusChanged(z, shareMediaItem.getMediaType());
                }
                this.nk.b.setImageResource(shareMediaItem.isChecked() ? p.h(this.nl.getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString()) : p.h(this.nl.getContext(), "bdsocialshare_" + shareMediaItem.getMediaType().toString() + "_gray"));
            } else if (shareMediaItem.isAuthorized() || !z) {
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("client_id", SocialShare.getInstance(this.nl.getContext()).getClientId());
                bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, shareMediaItem.getMediaType().toString());
                Intent intent = new Intent(this.nl.getContext(), SocialOAuthActivity.class);
                intent.addFlags(268435456);
                intent.putExtras(bundle);
                SocialOAuthActivity.setListener(new z(this, shareMediaItem));
                this.nl.getContext().getApplicationContext().startActivity(intent);
            }
        }
    }
}
