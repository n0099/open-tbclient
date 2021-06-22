package d.a.o0.e2.k.g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.l;
import d.a.n0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f57428e;
    public a2 k;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f57429f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f57430g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57431h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57432i = false;
    public boolean j = true;
    public boolean l = false;
    public boolean m = false;
    public String n = "";
    public int o = -1;
    public View.OnLongClickListener p = null;
    public View.OnClickListener q = null;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f57433a = 3;

        /* renamed from: b  reason: collision with root package name */
        public View f57434b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57435c;

        /* renamed from: d  reason: collision with root package name */
        public View f57436d;

        public a(Context context, View view) {
            this.f57436d = view;
            this.f57434b = view.findViewById(R.id.divider_line);
            TextView textView = (TextView) view.findViewById(R.id.center_reply_text);
            this.f57435c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i2) {
            if (i2 != this.f57433a) {
                SkinManager.setBackgroundColor(this.f57434b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f57435c, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f57435c, R.color.CAM_X0201);
                this.f57435c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i2, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.f57433a = i2;
        }
    }

    /* renamed from: d.a.o0.e2.k.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1336b {

        /* renamed from: a  reason: collision with root package name */
        public int f57437a = 3;

        /* renamed from: b  reason: collision with root package name */
        public View f57438b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f57439c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f57440d;

        /* renamed from: e  reason: collision with root package name */
        public TbRichTextView f57441e;

        /* renamed from: f  reason: collision with root package name */
        public View f57442f;
    }

    public b(Context context) {
        this.f57428e = null;
        this.f57428e = context;
    }

    public View a() {
        View inflate = LayoutInflater.from(this.f57428e).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.f57428e, inflate));
        return inflate;
    }

    public View b() {
        C1336b c1336b = new C1336b();
        View inflate = LayoutInflater.from(this.f57428e).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c1336b.f57438b = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        c1336b.f57439c = linearLayout;
        if (this.l) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = l.g(this.f57428e, R.dimen.ds8);
            layoutParams.bottomMargin = l.g(this.f57428e, R.dimen.ds8);
            c1336b.f57439c.setLayoutParams(layoutParams);
        }
        c1336b.f57440d = (TextView) inflate.findViewById(R.id.manage_btn);
        c1336b.f57441e = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c1336b.f57442f = inflate.findViewById(R.id.divide_bottom_view);
        c1336b.f57441e.getLayoutStrategy().t();
        if (!this.l) {
            c1336b.f57441e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c1336b.f57441e.getLayoutStrategy().j(0);
            c1336b.f57441e.getLayoutStrategy().l(l.g(this.f57428e, R.dimen.tbds20));
            c1336b.f57441e.getLayoutStrategy().m(l.g(this.f57428e, R.dimen.tbds14));
            c1336b.f57441e.setMaxLines(4);
            c1336b.f57441e.setTextEllipsize(TextUtils.TruncateAt.END);
            c1336b.f57441e.setAddTruncateListener(true);
        }
        c1336b.f57441e.setSubPbPost(true);
        c1336b.f57441e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        c1336b.f57441e.setIsNeedResizeEmotion(true);
        c1336b.f57441e.setTextSize(TbConfig.getContentSizeOfLzl());
        c1336b.f57441e.setTextCenter(true);
        c1336b.f57441e.setOnClickListener(this.q);
        c1336b.f57440d.setOnClickListener(this.f57429f);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c1336b);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(C1336b c1336b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        if (c1336b == null || postData == null) {
            return;
        }
        boolean z7 = true;
        boolean z8 = false;
        if (!postData.a0) {
            Context context = this.f57428e;
            if (context instanceof d.a.o0.e2.k.a) {
                d.a.o0.e2.k.a aVar = (d.a.o0.e2.k.a) context;
                postData.z0(aVar.getPageContext(), postData.t() != null && aVar.isHost(postData.t().getUserId()));
            }
        }
        if (z3) {
            SkinManager.setBackgroundColor(c1336b.f57438b, R.color.CAM_X0204);
        } else {
            c1336b.f57438b.setBackgroundResource(0);
        }
        if (postData.Z()) {
            c1336b.f57442f.setVisibility(0);
        } else {
            c1336b.f57442f.setVisibility(8);
        }
        c1336b.f57441e.setPadding(0, 0, 0, 0);
        if (postData.t() != null) {
            String name_show = postData.t().getName_show();
            String userId = postData.t().getUserId();
            SparseArray sparseArray2 = (SparseArray) c1336b.f57438b.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                c1336b.f57438b.setTag(sparseArray2);
                c1336b.f57441e.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_photo_username, name_show);
            sparseArray2.put(R.id.tag_photo_userid, userId);
            sparseArray2.put(R.id.tag_clip_board, postData);
            sparseArray2.put(R.id.tag_is_subpb, Boolean.TRUE);
        }
        c1336b.f57441e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
        c1336b.f57441e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        d(postData, this.l);
        TbRichText K = postData.K();
        if (K != null) {
            c1336b.f57441e.setVoiceViewRes(R.layout.voice_play_btn_new);
            c1336b.f57441e.setIsFromCDN(this.j);
            if (c1336b.f57437a != TbadkCoreApplication.getInst().getSkinType()) {
                K.isChanged = true;
            }
            c1336b.f57441e.setText(K);
        }
        String userId2 = postData.t().getUserId();
        int i2 = this.f57430g;
        if (i2 != 0) {
            z4 = (i2 == 1002 || i2 == 3) ? false : true;
            z5 = (this.f57430g == 3 || this.k.V1()) ? false : true;
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z4 = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z4 = false;
            }
        } else {
            z4 = false;
            z5 = false;
        }
        if (this.f57431h) {
            if (!this.k.V1()) {
                z5 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = true;
                } else {
                    z7 = z5;
                }
                c1336b.f57440d.setVisibility(8);
                sparseArray = (SparseArray) c1336b.f57438b.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    c1336b.f57438b.setTag(sparseArray);
                    c1336b.f57441e.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.n);
                if (!z4) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f57430g));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
                sparseArray.put(R.id.tag_clip_board, postData);
                if (!z6) {
                    if (this.k != null) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.t() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                        }
                        if (this.k.o0() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.k.o0());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                    }
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z7) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f57430g));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z8));
                    sparseArray.put(R.id.tag_del_post_type, 2);
                    sparseArray.put(R.id.tag_del_post_id, postData.E());
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.W()));
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                if (this.l && z2 && this.m) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1336b.f57439c.getLayoutParams();
                    layoutParams.topMargin = l.g(this.f57428e, R.dimen.ds32);
                    layoutParams.bottomMargin = l.g(this.f57428e, R.dimen.ds8);
                    c1336b.f57439c.setLayoutParams(layoutParams);
                }
                if (this.l && !z2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c1336b.f57439c.getLayoutParams();
                    layoutParams2.topMargin = l.g(this.f57428e, R.dimen.ds8);
                    layoutParams2.bottomMargin = l.g(this.f57428e, R.dimen.ds8);
                    c1336b.f57439c.setLayoutParams(layoutParams2);
                }
                c1336b.f57440d.setTag(sparseArray);
                c1336b.f57441e.setTag(sparseArray);
                c1336b.f57437a = TbadkCoreApplication.getInst().getSkinType();
                c1336b.f57441e.setOnLongClickListener(this.p);
            }
        }
        z6 = false;
        if (userId2 == null) {
        }
        z7 = z5;
        c1336b.f57440d.setVisibility(8);
        sparseArray = (SparseArray) c1336b.f57438b.getTag();
        if (sparseArray == null) {
        }
        sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.n);
        if (!z4) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        sparseArray.put(R.id.tag_clip_board, postData);
        if (!z6) {
        }
        if (!z7) {
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c1336b.f57439c.getLayoutParams();
            layoutParams3.topMargin = l.g(this.f57428e, R.dimen.ds32);
            layoutParams3.bottomMargin = l.g(this.f57428e, R.dimen.ds8);
            c1336b.f57439c.setLayoutParams(layoutParams3);
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c1336b.f57439c.getLayoutParams();
            layoutParams22.topMargin = l.g(this.f57428e, R.dimen.ds8);
            layoutParams22.bottomMargin = l.g(this.f57428e, R.dimen.ds8);
            c1336b.f57439c.setLayoutParams(layoutParams22);
        }
        c1336b.f57440d.setTag(sparseArray);
        c1336b.f57441e.setTag(sparseArray);
        c1336b.f57437a = TbadkCoreApplication.getInst().getSkinType();
        c1336b.f57441e.setOnLongClickListener(this.p);
    }

    public final void d(PostData postData, boolean z) {
        TbRichText K;
        SpannableStringBuilder E;
        String str;
        if (postData == null || (K = postData.K()) == null) {
            return;
        }
        ArrayList<TbRichTextData> y = K.y();
        if (ListUtils.isEmpty(y)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = y.get(y.size() - 1);
            int type = tbRichTextData != null ? tbRichTextData.getType() : -1;
            if (type == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.R());
                if (y.size() > 1) {
                    if ((y.get(y.size() + (-2)) != null ? y.get(y.size() - 2).getType() : -1) != type) {
                        str2 = StringHelper.getFormatTime(postData.R());
                    }
                }
                SpannableStringBuilder E2 = tbRichTextData.E();
                if (K.hasAppendTime && E2 != 0 && K.appendLength <= E2.length()) {
                    E2.delete(E2.length() - K.appendLength, E2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (E2 != null) {
                    E2.append((CharSequence) str);
                }
                K.hasAppendTime = true;
                K.appendLength = str.length();
            } else if (K.hasAppendTime) {
                str = "";
            } else {
                String formatTime = StringHelper.getFormatTime(postData.R());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.w(forceLToR);
                K.hasAppendTime = true;
                K.appendLength = forceLToR.length();
                y.add(tbRichTextData);
                str = forceLToR;
            }
            SpannableStringBuilder E3 = tbRichTextData.E();
            if (E3 == null || str.length() > E3.length()) {
                return;
            }
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
            E3.setSpan(absoluteSizeSpan, E3.length() - str.length(), E3.length(), 33);
            E3.setSpan(foregroundColorSpan, E3.length() - str.length(), E3.length(), 33);
            return;
        }
        TbRichTextData tbRichTextData2 = y.get(y.size() - 1);
        if (K.hasAppendTime && tbRichTextData2 != null && (E = tbRichTextData2.E()) != null && K.appendLength <= E.length()) {
            E.delete(E.length() - K.appendLength, E.length());
        }
        K.hasAppendTime = false;
        K.appendLength = 0;
    }

    public void e(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void f(boolean z) {
        this.j = z;
    }

    public void g(String str) {
        this.n = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1336b c1336b;
        PostData postData = getItem(i2) instanceof PostData ? (PostData) getItem(i2) : null;
        if (view == null) {
            if (postData.getType() == PostData.z0) {
                view = a();
            } else {
                view = b();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.z0) {
            view = b();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.z0) {
            view = a();
        }
        if ((view.getTag() instanceof SparseArray) && (c1336b = (C1336b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.f57432i && i2 + 1 >= getCount();
            boolean z2 = i2 == this.o;
            c(c1336b, postData, !z, i2 == 0, z2);
            if (z2) {
                this.o = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).a(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    public void h(View.OnClickListener onClickListener) {
        this.f57429f = onClickListener;
    }

    public void i(a2 a2Var) {
        this.k = a2Var;
    }

    public void j(int i2, boolean z) {
        this.f57430g = i2;
        this.f57431h = z;
    }
}
