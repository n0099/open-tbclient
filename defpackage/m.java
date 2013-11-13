package defpackage;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.zeus.Headers;
/* renamed from: m  reason: default package */
/* loaded from: classes.dex */
public class m extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2881a = m.class.getSimpleName();
    private ImageView b;
    private ImageView c;
    private TextView d;
    private boolean e;
    private Location f;
    private String g;
    private SocialShareConfig h;
    private Context i;

    public m(Context context) {
        super(context);
        this.e = false;
        this.i = context;
        this.h = SocialShareConfig.getInstance(context);
        this.b = new ImageView(context);
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.b.setImageDrawable(DrawableUtils.getDrawable(context, this.h.getAssetFileName(Headers.LOCATION)));
        this.b.setId(101);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DrawableUtils.fix720px(context, 18), DrawableUtils.fix720px(context, 23));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = DrawableUtils.fix720px(context, 14);
        layoutParams.rightMargin = DrawableUtils.fix720px(context, 9);
        addView(this.b, layoutParams);
        this.d = new TextView(context);
        this.d.setText(this.h.getString("insert_location"));
        this.d.setTextColor(-4934476);
        this.d.setTextSize(0, DrawableUtils.fix720px(context, 22));
        this.d.setPadding(0, 0, DrawableUtils.fix720px(context, 14), 0);
        this.d.setGravity(17);
        this.d.setId(102);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 101);
        addView(this.d, layoutParams2);
        this.c = new ImageView(context);
        this.c.setScaleType(ImageView.ScaleType.FIT_XY);
        this.c.setImageDrawable(DrawableUtils.getDrawable(context, this.h.getAssetFileName("icon_x")));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DrawableUtils.fix720px(context, 24), DrawableUtils.fix720px(context, 18));
        layoutParams3.addRule(1, 102);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = DrawableUtils.fix720px(context, 14);
        addView(this.c, layoutParams3);
        setOnClickListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.g = str;
        this.e = true;
        this.d.setText(str);
        this.c.setVisibility(0);
        this.b.setImageDrawable(DrawableUtils.getDrawable(getContext(), this.h.getAssetFileName("location_enabled")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Location location) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("x", String.valueOf(location.getLongitude()));
        requestParams.put("y", String.valueOf(location.getLatitude()));
        requestParams.put("r", String.valueOf(location.getAccuracy()));
        requestParams.put("prod", "BaiduSocialShare");
        requestParams.put("addr", "city|street");
        Log.e("LocationPreview", requestParams.getQueryString());
        new AsyncHttpClient().get(getContext(), "http://loc.map.baidu.com/wloc", requestParams, new s(this, requestParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.e = false;
        this.g = null;
        this.d.setText(this.h.getString("unknown_street"));
        this.c.setVisibility(8);
    }

    public void a(Location location) {
        if (location == null) {
            this.e = false;
            this.g = null;
            this.c.setVisibility(8);
            return;
        }
        this.f = location;
        this.d.setText(this.h.getString("get_location"));
        b(location);
    }

    public boolean a() {
        return this.e;
    }

    public Location b() {
        return this.f;
    }
}
