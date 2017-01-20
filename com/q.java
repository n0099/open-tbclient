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
    final /* synthetic */ LocationPreview dy;

    public q(LocationPreview locationPreview) {
        this.dy = locationPreview;
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
        z = this.dy.f;
        if (z) {
            this.dy.f = false;
            textView2 = this.dy.e;
            socialShareConfig2 = this.dy.b;
            textView2.setText(socialShareConfig2.getString("insert_location"));
            imageView = this.dy.d;
            imageView.setVisibility(8);
            return;
        }
        str = this.dy.h;
        if (!TextUtils.isEmpty(str)) {
            LocationPreview locationPreview = this.dy;
            str2 = this.dy.h;
            locationPreview.a(str2);
            return;
        }
        textView = this.dy.e;
        socialShareConfig = this.dy.b;
        textView.setText(socialShareConfig.getString("get_location"));
        location = this.dy.g;
        if (location != null) {
            LocationPreview locationPreview2 = this.dy;
            location2 = this.dy.g;
            locationPreview2.a(location2);
            return;
        }
        try {
            if (this.dy.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                new PositionManager(this.dy.getContext()).requestLoation(new r(this));
            }
        } catch (Exception e) {
        }
    }
}
