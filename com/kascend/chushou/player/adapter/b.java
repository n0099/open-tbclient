package com.kascend.chushou.player.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.PrivacyItem;
import com.kascend.chushou.widget.OnlineToggleButton;
import java.util.List;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int a;
    private Context b;
    private List<PrivacyItem> c;
    private boolean e = false;
    private com.kascend.chushou.view.a.a<PrivacyItem> mKx;

    public b(int i, Context context, List<PrivacyItem> list, com.kascend.chushou.view.a.a<PrivacyItem> aVar) {
        this.a = 1;
        this.a = i;
        this.b = context;
        this.c = list;
        this.mKx = aVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.c.get(i).mType;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2;
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i == 0) {
            return new C0799b(from.inflate(this.a == 3 ? a.h.view_privacy_setting_group_header_black : a.h.view_privacy_setting_group_header, viewGroup, false));
        } else if (i == 2) {
            return new c(from.inflate(this.a == 3 ? a.h.view_privacy_setting_toggle_black : a.h.view_privacy_setting_toggle_black, viewGroup, false), this.mKx);
        } else if (i == 3) {
            if (this.a == 2) {
                i2 = a.h.view_privacy_setting_check_room;
            } else if (this.a == 3) {
                i2 = a.h.view_privacy_setting_check_room_black;
            } else {
                i2 = a.h.view_privacy_setting_check;
            }
            return new a(from.inflate(i2, viewGroup, false), this.mKx, this.a);
        } else {
            return null;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        PrivacyItem privacyItem = this.c.get(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            ((C0799b) viewHolder).a(privacyItem);
        } else if (itemViewType == 2) {
            ((c) viewHolder).a(privacyItem);
        } else if (itemViewType == 3) {
            ((a) viewHolder).a(privacyItem);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.c != null) {
            return this.c.size();
        }
        return 0;
    }

    /* renamed from: com.kascend.chushou.player.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0799b extends RecyclerView.ViewHolder {
        private TextView a;

        public C0799b(View view) {
            super(view);
            this.a = (TextView) view.findViewById(a.f.tv_text);
        }

        public void a(PrivacyItem privacyItem) {
            this.a.setText(privacyItem.mText);
        }
    }

    /* loaded from: classes5.dex */
    private static class c extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView c;
        private View f;
        private View g;
        private View h;
        private int i;
        private FrescoThumbnailView mKA;
        private OnlineToggleButton mKB;
        private PrivacyItem mKy;
        private com.kascend.chushou.view.a.a mKz;

        public c(View view, com.kascend.chushou.view.a.a aVar) {
            super(view);
            this.c = (TextView) view.findViewById(a.f.tv_text);
            this.mKA = (FrescoThumbnailView) view.findViewById(a.f.iv_icon);
            this.mKB = (OnlineToggleButton) view.findViewById(a.f.btn_toggle);
            this.f = view.findViewById(a.f.sp_top);
            this.g = view.findViewById(a.f.v_top_line);
            this.h = view.findViewById(a.f.v_bottom_line);
            this.mKz = aVar;
            view.setOnClickListener(this);
            this.i = tv.chushou.zues.utils.a.dip2px(view.getContext(), 10.0f);
        }

        public void a(PrivacyItem privacyItem) {
            this.mKy = privacyItem;
            b(privacyItem);
            this.c.setText(privacyItem.mText);
            if (h.isEmpty(privacyItem.mWebIcon)) {
                this.mKA.setVisibility(8);
            } else {
                this.mKA.i(privacyItem.mWebIcon, a.e.icon_room_id, 0, 0);
                this.mKA.setVisibility(0);
            }
            this.mKB.a(privacyItem);
            if (privacyItem.mShowing) {
                this.itemView.setVisibility(0);
            } else {
                this.itemView.setVisibility(8);
            }
            if (this.mKy.mPopShow) {
                this.c.setTextSize(14.0f);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.mKz.b(view, this.mKy);
        }

        private void b(PrivacyItem privacyItem) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            if (privacyItem.mItemPosition == 0) {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                layoutParams.setMargins(0, 0, 0, 0);
            } else if (privacyItem.mItemPosition == 1) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                layoutParams.setMargins(0, 0, 0, 0);
            } else if (privacyItem.mItemPosition == 2) {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            } else if (privacyItem.mItemPosition == 3) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            } else if (privacyItem.mItemPosition == 4) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            } else if (privacyItem.mItemPosition == 5) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
                layoutParams.setMargins(0, 0, 0, 0);
            } else if (privacyItem.mItemPosition == 6) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            } else if (privacyItem.mItemPosition == 7) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView c;
        private ImageView e;
        private View f;
        private View g;
        private View h;
        private int i;
        private int j;
        private FrescoThumbnailView mKA;
        private PrivacyItem mKy;
        private com.kascend.chushou.view.a.a mKz;

        public a(View view, com.kascend.chushou.view.a.a aVar, int i) {
            super(view);
            this.j = i;
            this.f = view.findViewById(a.f.sp_top);
            this.g = view.findViewById(a.f.v_top_line);
            this.h = view.findViewById(a.f.v_bottom_line);
            this.c = (TextView) view.findViewById(a.f.tv_title);
            this.mKA = (FrescoThumbnailView) view.findViewById(a.f.iv_icon);
            this.e = (ImageView) view.findViewById(a.f.iv_check);
            this.mKz = aVar;
            view.setOnClickListener(this);
            this.i = tv.chushou.zues.utils.a.dip2px(view.getContext(), 10.0f);
        }

        public void a(PrivacyItem privacyItem) {
            this.mKy = privacyItem;
            b(privacyItem);
            this.c.setText(privacyItem.mText);
            if (h.isEmpty(privacyItem.mWebIcon)) {
                this.mKA.setVisibility(8);
            } else {
                this.mKA.i(privacyItem.mWebIcon, a.e.icon_default_badge, 0, 0);
                this.mKA.setVisibility(0);
            }
            if (privacyItem.mState == 0) {
                int i = a.e.icon_setting_item_uncheck;
                if (this.j == 3) {
                    i = a.e.icon_face_show_setting_item_multi_uncheck;
                }
                this.e.setImageResource(i);
            } else if (privacyItem.mState == 1) {
                if (privacyItem.mMulti) {
                    int i2 = a.e.icon_setting_item_multi_check;
                    if (this.j == 3) {
                        i2 = a.e.icon_face_show_setting_item_multi_check;
                    }
                    this.e.setImageResource(i2);
                } else {
                    this.e.setImageResource(a.e.icon_setting_item_single_check);
                }
            }
            if (privacyItem.mShowing) {
                this.itemView.setVisibility(0);
            } else {
                this.itemView.setVisibility(8);
            }
            if (this.mKy.mPopShow) {
                this.c.setTextSize(14.0f);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.mKz != null) {
                this.mKz.b(view, this.mKy);
            }
        }

        private void b(PrivacyItem privacyItem) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            if (privacyItem.mItemPosition == 0) {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                layoutParams.setMargins(0, 0, 0, 0);
            } else if (privacyItem.mItemPosition == 1) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                layoutParams.setMargins(0, 0, 0, 0);
            } else if (privacyItem.mItemPosition == 2) {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            } else if (privacyItem.mItemPosition == 3) {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
                this.h.setVisibility(0);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            } else if (privacyItem.mItemPosition == 4) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            } else if (privacyItem.mItemPosition == 5) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
                layoutParams.setMargins(0, 0, 0, 0);
            } else if (privacyItem.mItemPosition == 6) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            } else if (privacyItem.mItemPosition == 7) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(0);
                layoutParams.setMargins(this.i, 0, this.i, 0);
            }
        }
    }
}
