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
    final /* synthetic */ LocationPreview dA;

    public q(LocationPreview locationPreview) {
        this.dA = locationPreview;
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
        z = this.dA.f;
        if (z) {
            this.dA.f = false;
            textView2 = this.dA.e;
            socialShareConfig2 = this.dA.b;
            textView2.setText(socialShareConfig2.getString("insert_location"));
            imageView = this.dA.d;
            imageView.setVisibility(8);
            return;
        }
        str = this.dA.h;
        if (!TextUtils.isEmpty(str)) {
            LocationPreview locationPreview = this.dA;
            str2 = this.dA.h;
            locationPreview.a(str2);
            return;
        }
        textView = this.dA.e;
        socialShareConfig = this.dA.b;
        textView.setText(socialShareConfig.getString("get_location"));
        location = this.dA.g;
        if (location != null) {
            LocationPreview locationPreview2 = this.dA;
            location2 = this.dA.g;
            locationPreview2.a(location2);
            return;
        }
        try {
            if (this.dA.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                new PositionManager(this.dA.getContext()).requestLoation(new r(this));
            }
        } catch (Exception e) {
        }
    }
}
