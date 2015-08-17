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
    final /* synthetic */ LocationPreview na;

    public q(LocationPreview locationPreview) {
        this.na = locationPreview;
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
        z = this.na.f;
        if (z) {
            this.na.f = false;
            textView2 = this.na.e;
            socialShareConfig2 = this.na.b;
            textView2.setText(socialShareConfig2.getString("insert_location"));
            imageView = this.na.d;
            imageView.setVisibility(8);
            return;
        }
        str = this.na.h;
        if (!TextUtils.isEmpty(str)) {
            LocationPreview locationPreview = this.na;
            str2 = this.na.h;
            locationPreview.a(str2);
            return;
        }
        textView = this.na.e;
        socialShareConfig = this.na.b;
        textView.setText(socialShareConfig.getString("get_location"));
        location = this.na.g;
        if (location != null) {
            LocationPreview locationPreview2 = this.na;
            location2 = this.na.g;
            locationPreview2.a(location2);
            return;
        }
        try {
            if (this.na.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                new PositionManager(this.na.getContext()).requestLoation(new r(this));
            }
        } catch (Exception e) {
        }
    }
}
