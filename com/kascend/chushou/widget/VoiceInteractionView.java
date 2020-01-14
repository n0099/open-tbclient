package com.kascend.chushou.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.webkit.internal.ABTestConstants;
import com.google.android.flexbox.FlexboxLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.r;
import com.kascend.chushou.constants.MicMemberInfo;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.fresco.b;
/* loaded from: classes4.dex */
public class VoiceInteractionView extends FrameLayout implements View.OnClickListener {
    private TextView a;
    private LinearLayout b;
    private List<a> d;
    private boolean f;
    private boolean g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private FlexboxLayout ngR;
    private b ngS;

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void a(int i, MicMemberInfo micMemberInfo, boolean z);

        void b();
    }

    public VoiceInteractionView(@NonNull Context context) {
        this(context, null);
    }

    public VoiceInteractionView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList();
        this.f = false;
        this.g = false;
        this.h = 1000;
        this.i = 10000;
        this.j = ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT;
        this.k = 100000000;
        LayoutInflater.from(context).inflate(a.h.view_voice_interaction, (ViewGroup) this, true);
        this.ngR = (FlexboxLayout) findViewById(a.f.fbl_container);
        this.b = (LinearLayout) findViewById(a.f.ll_rule);
        this.a = (TextView) findViewById(a.f.tv_current_charts);
        this.b.setOnClickListener(this);
        this.a.setOnClickListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tv.chushou.zues.a.a.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tv.chushou.zues.a.a.cq(this);
    }

    @Subscribe
    public void onVoiceVolumesEvent(r rVar) {
        if (getVisibility() == 0) {
            for (a aVar : this.d) {
                if (aVar.ngT != null) {
                    try {
                        Integer num = rVar.a.get(Long.valueOf(Long.parseLong(aVar.ngT.uid)));
                        aVar.a(num != null && num.intValue() > 0);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.ll_rule) {
            if (this.ngS != null) {
                this.ngS.a();
            }
        } else if (id == a.f.tv_current_charts && this.ngS != null) {
            this.ngS.b();
        }
    }

    public void setupCount(int i) {
        if (i > 0 && this.ngR != null && this.d.size() != i) {
            this.ngR.removeAllViews();
            this.d.clear();
            for (int i2 = 0; i2 < i; i2++) {
                View a2 = a();
                this.d.add(new a(i2, a2));
                this.ngR.addView(a2, new FlexboxLayout.LayoutParams(tv.chushou.zues.utils.a.dip2px(getContext(), 48.0f), tv.chushou.zues.utils.a.dip2px(getContext(), 64.0f)));
            }
        }
    }

    public void a(boolean z, boolean z2, boolean z3) {
        this.f = z;
        this.g = z3;
        this.a.setVisibility(z ? 0 : 8);
    }

    public void a(List<MicMemberInfo> list) {
        SparseArray sparseArray = new SparseArray();
        for (MicMemberInfo micMemberInfo : list) {
            sparseArray.put(micMemberInfo.order, micMemberInfo);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.d.size()) {
                this.d.get(i2).a((MicMemberInfo) sparseArray.get(i2 + 1));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setOnActionListener(b bVar) {
        this.ngS = bVar;
    }

    private View a() {
        return LayoutInflater.from(getContext()).inflate(a.h.item_voice_interaction, (ViewGroup) null, false);
    }

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {
        private int b;
        private boolean c = true;
        private boolean d;
        private View e;
        private FrameLayout g;
        private ImageView h;
        private ImageView i;
        private TextView j;
        private LinearLayout k;
        private ImageView l;
        private TextView m;
        private FrescoThumbnailView mWW;
        private MicMemberInfo ngT;

        a(int i, View view) {
            this.b = i;
            this.e = view;
            view.setOnClickListener(this);
            this.mWW = (FrescoThumbnailView) view.findViewById(a.f.ftv_avatar);
            this.g = (FrameLayout) view.findViewById(a.f.fl_nobody);
            this.h = (ImageView) view.findViewById(a.f.iv_nobody);
            this.i = (ImageView) view.findViewById(a.f.iv_voice);
            this.j = (TextView) view.findViewById(a.f.tv_name);
            this.k = (LinearLayout) view.findViewById(a.f.ll_count);
            this.l = (ImageView) view.findViewById(a.f.iv_level);
            this.m = (TextView) view.findViewById(a.f.tv_count);
            this.j.setText(VoiceInteractionView.this.getContext().getString(a.i.str_order_without_name, Integer.valueOf(i + 1)));
        }

        public void a(MicMemberInfo micMemberInfo) {
            this.ngT = micMemberInfo;
            if (micMemberInfo == null) {
                b(false);
                c(true);
                this.j.setText(VoiceInteractionView.this.getContext().getString(a.i.str_order_without_name, Integer.valueOf(this.b + 1)));
                return;
            }
            c(false);
            b(micMemberInfo.micStatus == 1);
            this.mWW.i(micMemberInfo.avatar, com.kascend.chushou.view.a.a(micMemberInfo.gender), b.a.small, b.a.small);
            this.j.setText(VoiceInteractionView.this.getContext().getString(a.i.str_order_with_name, Integer.valueOf(micMemberInfo.order), micMemberInfo.nickname));
            this.m.setText(VoiceInteractionView.this.getContext().getString(a.i.str_ticket_count, VoiceInteractionView.this.a(micMemberInfo.contributePoint)));
        }

        public void a(boolean z) {
            if (!this.c && this.d) {
                if (z) {
                    this.i.setVisibility(0);
                    if (this.i.getDrawable() instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) this.i.getDrawable();
                        if (!animationDrawable.isRunning()) {
                            animationDrawable.start();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.i.getDrawable() instanceof AnimationDrawable) {
                    AnimationDrawable animationDrawable2 = (AnimationDrawable) this.i.getDrawable();
                    if (animationDrawable2.isRunning()) {
                        animationDrawable2.stop();
                    }
                }
                this.i.setVisibility(8);
            }
        }

        public void b(boolean z) {
            if (this.c) {
                if (this.i.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) this.i.getDrawable()).stop();
                }
                this.i.setVisibility(8);
            } else if (z) {
                if (!this.d) {
                    this.i.setImageResource(a.e.anim_voice_interaction);
                }
            } else {
                this.i.setVisibility(0);
                if (this.i.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) this.i.getDrawable()).stop();
                }
                this.i.setImageResource(a.e.icon_voice_interaction_close);
            }
            this.d = z;
        }

        public void c(boolean z) {
            this.c = z;
            if (z) {
                this.mWW.setVisibility(8);
                this.g.setVisibility(0);
                this.k.setVisibility(8);
                this.h.setImageResource(VoiceInteractionView.this.f ? a.e.icon_voice_interaction_lock : a.e.icon_voice_interaction_nobody);
                this.j.setVisibility(VoiceInteractionView.this.f ? 8 : 0);
                return;
            }
            this.mWW.setVisibility(0);
            this.g.setVisibility(8);
            this.k.setVisibility(VoiceInteractionView.this.g ? 0 : 8);
            this.j.setVisibility(0);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.c && VoiceInteractionView.this.ngS != null) {
                VoiceInteractionView.this.ngS.a(this.b, this.ngT, VoiceInteractionView.this.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / 100000000;
        long j3 = j % 100000000;
        if (j2 > 0) {
            sb.append(j2);
            sb.append(".");
            sb.append(j3 / 10000000);
            sb.append("亿");
            return sb.toString();
        }
        int i = (int) (j3 / 10000);
        long j4 = j3 % 10000;
        if (i > 0) {
            if (i >= 100) {
                sb.append(i);
                sb.append("万");
                return sb.toString();
            }
            sb.append(i);
            sb.append(".");
            sb.append(j4 / 1000);
            sb.append("万");
            return sb.toString();
        }
        sb.append(j4);
        return sb.toString();
    }
}
