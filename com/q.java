package com;

import android.location.Location;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.cloudsdk.common.util.PositionManager;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.uiwithlayout.LocationPreview;
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ LocationPreview cW;

    public q(LocationPreview locationPreview) {
        this.cW = locationPreview;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        TextView textView;
        SocialShareConfig socialShareConfig;
        Location location;
        Location location2;
        String str2;
        TextView textView2;
        SocialShareConfig socialShareConfig2;
        ImageView imageView;
        z = this.cW.f;
        if (z) {
            this.cW.f = false;
            textView2 = this.cW.e;
            socialShareConfig2 = this.cW.b;
            textView2.setText(socialShareConfig2.getString("insert_location"));
            imageView = this.cW.d;
            imageView.setVisibility(8);
            return;
        }
        str = this.cW.h;
        if (!TextUtils.isEmpty(str)) {
            LocationPreview locationPreview = this.cW;
            str2 = this.cW.h;
            locationPreview.a(str2);
            return;
        }
        textView = this.cW.e;
        socialShareConfig = this.cW.b;
        textView.setText(socialShareConfig.getString("get_location"));
        location = this.cW.g;
        if (location != null) {
            LocationPreview locationPreview2 = this.cW;
            location2 = this.cW.g;
            locationPreview2.a(location2);
            return;
        }
        try {
            if (this.cW.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                new PositionManager(this.cW.getContext()).requestLoation(new r(this));
            }
        } catch (Exception e) {
        }
    }
}
