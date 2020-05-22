package com.kascend.chushou.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.bean.Achievement;
import com.kascend.chushou.c.c;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.d.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class AchievementView extends RelativeLayout implements View.OnClickListener {
    private TextView a;
    private LinearLayout b;
    private TextView c;
    private List<a> d;
    private String e;

    public AchievementView(Context context) {
        this(context, null);
    }

    public AchievementView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList(3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.AchievementView, 0, 0);
        int i = obtainStyledAttributes.getInt(a.k.AchievementView_achieve_type, 0);
        obtainStyledAttributes.recycle();
        if (i == 1) {
            inflate(context, a.h.view_achievement_card, this);
        } else {
            inflate(context, a.h.view_achievement_normal, this);
        }
        this.a = (TextView) findViewById(a.f.tv_detail);
        this.b = (LinearLayout) findViewById(a.f.ll_items);
        this.c = (TextView) findViewById(a.f.tv_empty);
        this.d.add(new a((LinearLayout) findViewById(a.f.ll_item1), (FrescoThumbnailView) findViewById(a.f.iv_icon1), (TextView) findViewById(a.f.tv_name1), (TextView) findViewById(a.f.tv_desc1)));
        this.d.add(new a((LinearLayout) findViewById(a.f.ll_item2), (FrescoThumbnailView) findViewById(a.f.iv_icon2), (TextView) findViewById(a.f.tv_name2), (TextView) findViewById(a.f.tv_desc2)));
        this.d.add(new a((LinearLayout) findViewById(a.f.ll_item3), (FrescoThumbnailView) findViewById(a.f.iv_icon3), (TextView) findViewById(a.f.tv_name3), (TextView) findViewById(a.f.tv_desc3)));
        this.a.setOnClickListener(this);
    }

    public void a(Achievement achievement, String str) {
        ArrayList arrayList;
        this.e = str;
        if (achievement == null || h.isEmpty(achievement.medalList)) {
            this.b.setVisibility(8);
            this.c.setVisibility(0);
        } else {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            int size = achievement.medalList.size();
            if (size < 3) {
                ArrayList arrayList2 = new ArrayList(3);
                arrayList2.addAll(achievement.medalList);
                for (int i = 0; i < 3 - size; i++) {
                    arrayList2.add(null);
                }
                arrayList = arrayList2;
            } else {
                arrayList = achievement.medalList;
            }
            for (int i2 = 0; i2 < 3; i2++) {
                this.d.get(i2).a(arrayList.get(i2), str);
            }
        }
        if (achievement != null && achievement.detailItem != null && !TextUtils.isEmpty(achievement.detailItem.name)) {
            this.a.setText(getContext().getString(a.i.str_achievement_detail_format, achievement.detailItem.name));
        } else {
            this.a.setText(a.i.str_achievement_detail);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.tv_detail && !TextUtils.isEmpty(this.e)) {
            com.kascend.chushou.d.a.a(getContext(), c.a(39).replace("uid", this.e), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        public View a;
        public TextView c;
        public TextView d;
        public FrescoThumbnailView mTX;

        public a(View view, FrescoThumbnailView frescoThumbnailView, TextView textView, TextView textView2) {
            this.a = view;
            this.mTX = frescoThumbnailView;
            this.c = textView;
            this.d = textView2;
        }

        public void a(final Achievement.Medal medal, final String str) {
            if (medal == null) {
                this.a.setVisibility(8);
                return;
            }
            this.a.setVisibility(0);
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.widget.AchievementView.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ListItem listItem = new ListItem();
                    listItem.mType = "96";
                    listItem.mUrl = c.a(40) + "uid=" + str + "&type=" + medal.type;
                    e.a(a.this.a.getContext(), listItem, (JSONObject) null);
                }
            });
            this.mTX.h(medal.icon, a.e.icon_achievement_default, 0, 0);
            this.c.setText(medal.name);
            this.d.setText(medal.desc);
        }
    }
}
