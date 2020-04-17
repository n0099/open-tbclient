package com.kascend.chushou.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.coremedia.iso.boxes.MetaBox;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.o;
import com.kascend.chushou.c.b;
import com.kascend.chushou.c.c;
import com.kascend.chushou.constants.ListItem;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.chushou.zues.utils.e;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class RecommendView extends LinearLayout {
    protected Context a;
    private ArrayList<ListItem> b;
    private a mFK;

    /* loaded from: classes5.dex */
    public interface a {
        void a(String str);
    }

    public RecommendView(Context context) {
        this(context, null);
        a(context);
    }

    public RecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        setOrientation(0);
    }

    public void a(String str, a aVar) {
        this.mFK = aVar;
        a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null) {
            removeAllViews();
            int size = this.b.size();
            if (size == 0) {
                setVisibility(8);
                return;
            }
            int min = Math.min(size, 3);
            for (int i = 0; i < min; i++) {
                ListItem listItem = this.b.get(i);
                View inflate = LayoutInflater.from(this.a).inflate(a.h.recommendview_item, (ViewGroup) null, false);
                ((FrescoThumbnailView) inflate.findViewById(a.f.iv_thumb)).bU(listItem.mCover, a.e.def_recmd);
                inflate.setTag(listItem);
                inflate.setClickable(true);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.widget.RecommendView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Object tag = view.getTag();
                        if (tag != null && (tag instanceof ListItem)) {
                            ListItem listItem2 = (ListItem) tag;
                            if (listItem2.mType != null && listItem2.mType.equals("1")) {
                                o oVar = new o();
                                oVar.mnr = listItem2;
                                oVar.b = "recommend";
                                oVar.c = RecommendView.this.a;
                                oVar.g = listItem2.mLiveType;
                                tv.chushou.zues.a.a.post(oVar);
                            }
                        }
                    }
                });
                addView(inflate);
            }
            setVisibility(0);
        }
    }

    private void a(String str) {
        if (tv.chushou.zues.utils.a.dJS()) {
            c.dwG().b(new b() { // from class: com.kascend.chushou.widget.RecommendView.2
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        try {
                            int optInt = jSONObject.optInt("code");
                            e.i("RecommendView", "rc = " + optInt + " msg=" + jSONObject.optString("message"));
                            if (optInt == 0 && jSONObject.has("data")) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                ArrayList arrayList = new ArrayList();
                                JSONArray optJSONArray = optJSONObject.optJSONArray("recommend");
                                if (optJSONArray != null) {
                                    int length = optJSONArray.length();
                                    for (int i = 0; i < length; i++) {
                                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                        ListItem listItem = new ListItem();
                                        listItem.mCover = jSONObject2.optString("cover");
                                        listItem.mName = jSONObject2.optString("name");
                                        listItem.mType = jSONObject2.optString("type");
                                        listItem.mTargetKey = jSONObject2.optString("targetKey");
                                        if (jSONObject2.has(MetaBox.TYPE)) {
                                            JSONObject jSONObject3 = jSONObject2.getJSONObject(MetaBox.TYPE);
                                            listItem.mLiveType = jSONObject3.optString("liveType");
                                            listItem.mSC = jSONObject3.optString("_sc");
                                        }
                                        arrayList.add(listItem);
                                    }
                                }
                                String optString = optJSONObject.optString("background");
                                if (!h.isEmpty(optString) && RecommendView.this.mFK != null) {
                                    RecommendView.this.mFK.a(optString);
                                }
                                if (!h.isEmpty(arrayList)) {
                                    RecommendView.this.b = arrayList;
                                    RecommendView.this.a();
                                } else {
                                    RecommendView.this.setVisibility(8);
                                }
                                e.i("RecommendView", "parser sucess");
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.e("RecommendView", "error " + e.toString());
                            RecommendView.this.setVisibility(8);
                            return;
                        }
                    }
                    RecommendView.this.setVisibility(8);
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    RecommendView.this.setVisibility(8);
                }
            }, str);
        } else {
            setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.clear();
            this.b = null;
        }
        this.mFK = null;
        this.a = null;
    }
}
