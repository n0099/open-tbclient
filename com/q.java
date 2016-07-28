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
    final /* synthetic */ LocationPreview dz;

    public q(LocationPreview locationPreview) {
        this.dz = locationPreview;
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
        z = this.dz.f;
        if (z) {
            this.dz.f = false;
            textView2 = this.dz.e;
            socialShareConfig2 = this.dz.b;
            textView2.setText(socialShareConfig2.getString("insert_location"));
            imageView = this.dz.d;
            imageView.setVisibility(8);
            return;
        }
        str = this.dz.h;
        if (!TextUtils.isEmpty(str)) {
            LocationPreview locationPreview = this.dz;
            str2 = this.dz.h;
            locationPreview.a(str2);
            return;
        }
        textView = this.dz.e;
        socialShareConfig = this.dz.b;
        textView.setText(socialShareConfig.getString("get_location"));
        location = this.dz.g;
        if (location != null) {
            LocationPreview locationPreview2 = this.dz;
            location2 = this.dz.g;
            locationPreview2.a(location2);
            return;
        }
        try {
            if (this.dz.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                new PositionManager(this.dz.getContext()).requestLoation(new r(this));
            }
        } catch (Exception e) {
        }
    }
}
