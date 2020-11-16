package com.kascend.chushou.view.b;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.c.f;
import com.kascend.chushou.constants.EmojiGiftDetail;
import com.kascend.chushou.constants.GeneralGift;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.ParserRet;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.zues.utils.g;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes6.dex */
public class a extends com.kascend.chushou.view.base.a implements View.OnClickListener {
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private boolean l;
    private JSONObject m;
    private String n;
    private String o;
    private FrescoThumbnailView pvl;
    private EmojiGiftDetail pzn;

    public static a b(String str, JSONObject jSONObject, String str2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("giftId", str);
        bundle.putString("currentRoomId", str2);
        if (jSONObject != null) {
            bundle.putString("data", jSONObject.toString());
        }
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.kascend.chushou.view.base.a, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, a.j.user_level_dialog);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.n = arguments.getString("giftId");
            this.o = arguments.getString("currentRoomId");
            String string = arguments.getString("data");
            if (string != null) {
                try {
                    this.m = new JSONObject(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    if (this.m == null) {
                        this.m = new JSONObject();
                    }
                    this.m.put("_fromPos", "78");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        a(tv.chushou.zues.utils.a.dip2px(this.b, 270.0f), -2);
    }

    @Override // com.kascend.chushou.view.base.a
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(a.h.dialog_emoji_gift, viewGroup, false);
        this.pvl = (FrescoThumbnailView) inflate.findViewById(a.f.ftv);
        this.d = (TextView) inflate.findViewById(a.f.tv_name);
        this.e = (TextView) inflate.findViewById(a.f.tv_price);
        this.f = (TextView) inflate.findViewById(a.f.tv_desc);
        this.g = (TextView) inflate.findViewById(a.f.tv_from);
        this.h = (TextView) inflate.findViewById(a.f.tv_go_to);
        this.i = (TextView) inflate.findViewById(a.f.tv_subscribe);
        this.j = inflate.findViewById(a.f.iv_online);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        getDialog().setCanceledOnTouchOutside(true);
        return inflate;
    }

    @Override // com.kascend.chushou.view.base.a
    public void a(View view) {
        if (!tv.chushou.zues.utils.a.eHN()) {
            g.O(this.b, a.i.s_no_available_network);
        } else {
            com.kascend.chushou.c.c.etT().b(this.n, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.view.b.a.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str, JSONObject jSONObject) {
                    if (!a.this.b()) {
                        ParserRet eH = f.eH(jSONObject);
                        if (eH.mData != null && ((EmojiGiftDetail) eH.mData).generalGift != null) {
                            a.this.a((EmojiGiftDetail) eH.mData);
                        } else {
                            a(-1, "");
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str) {
                    if (!a.this.b()) {
                        g.O(a.this.b, a.i.s_network_busy);
                        a.this.dismiss();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EmojiGiftDetail emojiGiftDetail) {
        this.pzn = emojiGiftDetail;
        ViewGroup.LayoutParams layoutParams = this.pvl.getLayoutParams();
        GeneralGift generalGift = emojiGiftDetail.generalGift;
        if (generalGift.mGiftDetailHeight > 0 && generalGift.mGiftDetailWidth > 0) {
            layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.b, generalGift.mGiftDetailHeight);
            layoutParams.width = tv.chushou.zues.utils.a.dip2px(this.b, generalGift.mGiftDetailWidth);
        } else {
            layoutParams.height = tv.chushou.zues.utils.a.dip2px(this.b, 80.0f);
            layoutParams.width = tv.chushou.zues.utils.a.dip2px(this.b, 80.0f);
        }
        this.pvl.setLayoutParams(layoutParams);
        this.pvl.setAnim(true);
        com.kascend.chushou.view.a.a(this.pvl, generalGift.mIcon, b.C1127b.qpY, b.C1127b.qpY);
        this.d.setText(generalGift.mName);
        this.e.setText(generalGift.mWorthDesc);
        this.f.setText(generalGift.mDesc);
        if (h.isEmpty(generalGift.mTagLists)) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            this.g.setText(generalGift.mTagLists.get(0));
        }
        if (emojiGiftDetail.subscriber) {
            this.i.setText(a.i.str_attracted);
            this.i.setTextColor(getResources().getColor(a.c.second_black));
            this.i.setOnClickListener(null);
        } else {
            this.i.setText(a.i.str_go_to_subscribe);
            this.i.setTextColor(Color.parseColor("#FFFF5959"));
        }
        this.j.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.tv_go_to) {
            if (this.pzn != null) {
                if (TextUtils.equals(this.o, this.pzn.roomId)) {
                    dismiss();
                    return;
                }
                if (this.pzn.online) {
                    ListItem listItem = new ListItem();
                    listItem.mType = "1";
                    listItem.mTargetKey = this.pzn.roomId;
                    listItem.mLiveType = this.pzn.liveType;
                    com.kascend.chushou.d.e.a(this.b, listItem, this.m);
                } else {
                    ListItem listItem2 = new ListItem();
                    listItem2.mType = "5";
                    listItem2.mTargetKey = this.pzn.creatorUid;
                    com.kascend.chushou.d.e.a(this.b, listItem2, (JSONObject) null);
                }
                dismiss();
            }
        } else if (id == a.f.tv_subscribe && this.pzn != null) {
            a(this.pzn.subscriber);
        }
    }

    private void a(final boolean z) {
        if (!z) {
            if (!tv.chushou.zues.utils.a.eHN()) {
                g.O(this.b, a.i.s_no_wifi);
            } else if (com.kascend.chushou.d.e.c(this.b, null) && !this.l) {
                com.kascend.chushou.c.b bVar = new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.view.b.a.2
                    @Override // com.kascend.chushou.c.b
                    public void a() {
                        if (!a.this.b()) {
                            a.this.l = true;
                        }
                    }

                    @Override // com.kascend.chushou.c.b
                    public void a(String str, JSONObject jSONObject) {
                        if (!a.this.b()) {
                            a.this.l = false;
                            int optInt = jSONObject.optInt("code", -1);
                            if (optInt == 0) {
                                a.this.pzn.subscriber = z ? false : true;
                                if (z) {
                                    g.O(a.this.b, a.i.unsubscribe_success);
                                } else {
                                    g.O(a.this.b, a.i.subscribe_success);
                                }
                                a.this.b(a.this.pzn);
                            } else if (optInt == 401) {
                                com.kascend.chushou.d.e.b(a.this.b, (String) null);
                            } else {
                                a(optInt, jSONObject.optString("message", ""));
                            }
                        }
                    }

                    @Override // com.kascend.chushou.c.b
                    public void a(int i, String str) {
                        if (!a.this.b()) {
                            a.this.l = false;
                            if (h.isEmpty(str)) {
                                str = a.this.b.getString(a.i.subscribe_failed);
                            }
                            g.d(a.this.b, str);
                        }
                    }
                };
                String a2 = com.kascend.chushou.d.e.a("_fromView", "50");
                if (z) {
                    com.kascend.chushou.c.c.etT().b(bVar, (String) null, this.pzn.creatorUid, a2);
                } else {
                    com.kascend.chushou.c.c.etT().a(bVar, (String) null, this.pzn.creatorUid, a2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EmojiGiftDetail emojiGiftDetail) {
        if (emojiGiftDetail.subscriber) {
            this.i.setText(a.i.str_attracted);
            this.i.setTextColor(getResources().getColor(a.c.second_black));
            this.i.setOnClickListener(null);
            return;
        }
        this.i.setText(a.i.str_go_to_subscribe);
        this.i.setTextColor(Color.parseColor("#FF5959"));
    }
}
