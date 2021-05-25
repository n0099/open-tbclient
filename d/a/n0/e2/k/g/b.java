package d.a.n0.e2.k.g;

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
import d.a.m0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f53614e;
    public a2 k;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f53615f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f53616g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53617h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53618i = false;
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
        public int f53619a = 3;

        /* renamed from: b  reason: collision with root package name */
        public View f53620b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f53621c;

        /* renamed from: d  reason: collision with root package name */
        public View f53622d;

        public a(Context context, View view) {
            this.f53622d = view;
            this.f53620b = view.findViewById(R.id.divider_line);
            TextView textView = (TextView) view.findViewById(R.id.center_reply_text);
            this.f53621c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i2) {
            if (i2 != this.f53619a) {
                SkinManager.setBackgroundColor(this.f53620b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f53621c, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f53621c, R.color.CAM_X0201);
                this.f53621c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i2, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.f53619a = i2;
        }
    }

    /* renamed from: d.a.n0.e2.k.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1276b {

        /* renamed from: a  reason: collision with root package name */
        public int f53623a = 3;

        /* renamed from: b  reason: collision with root package name */
        public View f53624b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f53625c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f53626d;

        /* renamed from: e  reason: collision with root package name */
        public TbRichTextView f53627e;

        /* renamed from: f  reason: collision with root package name */
        public View f53628f;
    }

    public b(Context context) {
        this.f53614e = null;
        this.f53614e = context;
    }

    public View a() {
        View inflate = LayoutInflater.from(this.f53614e).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.f53614e, inflate));
        return inflate;
    }

    public View b() {
        C1276b c1276b = new C1276b();
        View inflate = LayoutInflater.from(this.f53614e).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c1276b.f53624b = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        c1276b.f53625c = linearLayout;
        if (this.l) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = l.g(this.f53614e, R.dimen.ds8);
            layoutParams.bottomMargin = l.g(this.f53614e, R.dimen.ds8);
            c1276b.f53625c.setLayoutParams(layoutParams);
        }
        c1276b.f53626d = (TextView) inflate.findViewById(R.id.manage_btn);
        c1276b.f53627e = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c1276b.f53628f = inflate.findViewById(R.id.divide_bottom_view);
        c1276b.f53627e.getLayoutStrategy().t();
        if (!this.l) {
            c1276b.f53627e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c1276b.f53627e.getLayoutStrategy().j(0);
            c1276b.f53627e.getLayoutStrategy().l(l.g(this.f53614e, R.dimen.tbds20));
            c1276b.f53627e.getLayoutStrategy().m(l.g(this.f53614e, R.dimen.tbds14));
            c1276b.f53627e.setMaxLines(4);
            c1276b.f53627e.setTextEllipsize(TextUtils.TruncateAt.END);
            c1276b.f53627e.setAddTruncateListener(true);
        }
        c1276b.f53627e.setSubPbPost(true);
        c1276b.f53627e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        c1276b.f53627e.setIsNeedResizeEmotion(true);
        c1276b.f53627e.setTextSize(TbConfig.getContentSizeOfLzl());
        c1276b.f53627e.setTextCenter(true);
        c1276b.f53627e.setOnClickListener(this.q);
        c1276b.f53626d.setOnClickListener(this.f53615f);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c1276b);
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
    public void c(C1276b c1276b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        if (c1276b == null || postData == null) {
            return;
        }
        boolean z7 = true;
        boolean z8 = false;
        if (!postData.a0) {
            Context context = this.f53614e;
            if (context instanceof d.a.n0.e2.k.a) {
                d.a.n0.e2.k.a aVar = (d.a.n0.e2.k.a) context;
                postData.z0(aVar.getPageContext(), postData.t() != null && aVar.isHost(postData.t().getUserId()));
            }
        }
        if (z3) {
            SkinManager.setBackgroundColor(c1276b.f53624b, R.color.CAM_X0204);
        } else {
            c1276b.f53624b.setBackgroundResource(0);
        }
        if (postData.Z()) {
            c1276b.f53628f.setVisibility(0);
        } else {
            c1276b.f53628f.setVisibility(8);
        }
        c1276b.f53627e.setPadding(0, 0, 0, 0);
        if (postData.t() != null) {
            String name_show = postData.t().getName_show();
            String userId = postData.t().getUserId();
            SparseArray sparseArray2 = (SparseArray) c1276b.f53624b.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                c1276b.f53624b.setTag(sparseArray2);
                c1276b.f53627e.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_photo_username, name_show);
            sparseArray2.put(R.id.tag_photo_userid, userId);
            sparseArray2.put(R.id.tag_clip_board, postData);
            sparseArray2.put(R.id.tag_is_subpb, Boolean.TRUE);
        }
        c1276b.f53627e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
        c1276b.f53627e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        d(postData, this.l);
        TbRichText K = postData.K();
        if (K != null) {
            c1276b.f53627e.setVoiceViewRes(R.layout.voice_play_btn_new);
            c1276b.f53627e.setIsFromCDN(this.j);
            if (c1276b.f53623a != TbadkCoreApplication.getInst().getSkinType()) {
                K.isChanged = true;
            }
            c1276b.f53627e.setText(K);
        }
        String userId2 = postData.t().getUserId();
        int i2 = this.f53616g;
        if (i2 != 0) {
            z4 = (i2 == 1002 || i2 == 3) ? false : true;
            z5 = (this.f53616g == 3 || this.k.U1()) ? false : true;
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
        if (this.f53617h) {
            if (!this.k.U1()) {
                z5 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = true;
                } else {
                    z7 = z5;
                }
                c1276b.f53626d.setVisibility(8);
                sparseArray = (SparseArray) c1276b.f53624b.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    c1276b.f53624b.setTag(sparseArray);
                    c1276b.f53627e.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.n);
                if (!z4) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f53616g));
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
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f53616g));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z8));
                    sparseArray.put(R.id.tag_del_post_type, 2);
                    sparseArray.put(R.id.tag_del_post_id, postData.E());
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.W()));
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                if (this.l && z2 && this.m) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1276b.f53625c.getLayoutParams();
                    layoutParams.topMargin = l.g(this.f53614e, R.dimen.ds32);
                    layoutParams.bottomMargin = l.g(this.f53614e, R.dimen.ds8);
                    c1276b.f53625c.setLayoutParams(layoutParams);
                }
                if (this.l && !z2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c1276b.f53625c.getLayoutParams();
                    layoutParams2.topMargin = l.g(this.f53614e, R.dimen.ds8);
                    layoutParams2.bottomMargin = l.g(this.f53614e, R.dimen.ds8);
                    c1276b.f53625c.setLayoutParams(layoutParams2);
                }
                c1276b.f53626d.setTag(sparseArray);
                c1276b.f53627e.setTag(sparseArray);
                c1276b.f53623a = TbadkCoreApplication.getInst().getSkinType();
                c1276b.f53627e.setOnLongClickListener(this.p);
            }
        }
        z6 = false;
        if (userId2 == null) {
        }
        z7 = z5;
        c1276b.f53626d.setVisibility(8);
        sparseArray = (SparseArray) c1276b.f53624b.getTag();
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
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c1276b.f53625c.getLayoutParams();
            layoutParams3.topMargin = l.g(this.f53614e, R.dimen.ds32);
            layoutParams3.bottomMargin = l.g(this.f53614e, R.dimen.ds8);
            c1276b.f53625c.setLayoutParams(layoutParams3);
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c1276b.f53625c.getLayoutParams();
            layoutParams22.topMargin = l.g(this.f53614e, R.dimen.ds8);
            layoutParams22.bottomMargin = l.g(this.f53614e, R.dimen.ds8);
            c1276b.f53625c.setLayoutParams(layoutParams22);
        }
        c1276b.f53626d.setTag(sparseArray);
        c1276b.f53627e.setTag(sparseArray);
        c1276b.f53623a = TbadkCoreApplication.getInst().getSkinType();
        c1276b.f53627e.setOnLongClickListener(this.p);
    }

    public final void d(PostData postData, boolean z) {
        TbRichText K;
        SpannableStringBuilder A;
        String str;
        if (postData == null || (K = postData.K()) == null) {
            return;
        }
        ArrayList<TbRichTextData> u = K.u();
        if (ListUtils.isEmpty(u)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = u.get(u.size() - 1);
            int type = tbRichTextData != null ? tbRichTextData.getType() : -1;
            if (type == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.R());
                if (u.size() > 1) {
                    if ((u.get(u.size() + (-2)) != null ? u.get(u.size() - 2).getType() : -1) != type) {
                        str2 = StringHelper.getFormatTime(postData.R());
                    }
                }
                SpannableStringBuilder A2 = tbRichTextData.A();
                if (K.hasAppendTime && A2 != 0 && K.appendLength <= A2.length()) {
                    A2.delete(A2.length() - K.appendLength, A2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (A2 != null) {
                    A2.append((CharSequence) str);
                }
                K.hasAppendTime = true;
                K.appendLength = str.length();
            } else if (K.hasAppendTime) {
                str = "";
            } else {
                String formatTime = StringHelper.getFormatTime(postData.R());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.s(forceLToR);
                K.hasAppendTime = true;
                K.appendLength = forceLToR.length();
                u.add(tbRichTextData);
                str = forceLToR;
            }
            SpannableStringBuilder A3 = tbRichTextData.A();
            if (A3 == null || str.length() > A3.length()) {
                return;
            }
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
            A3.setSpan(absoluteSizeSpan, A3.length() - str.length(), A3.length(), 33);
            A3.setSpan(foregroundColorSpan, A3.length() - str.length(), A3.length(), 33);
            return;
        }
        TbRichTextData tbRichTextData2 = u.get(u.size() - 1);
        if (K.hasAppendTime && tbRichTextData2 != null && (A = tbRichTextData2.A()) != null && K.appendLength <= A.length()) {
            A.delete(A.length() - K.appendLength, A.length());
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
        C1276b c1276b;
        PostData postData = getItem(i2) instanceof PostData ? (PostData) getItem(i2) : null;
        if (view == null) {
            if (postData.getType() == PostData.u0) {
                view = a();
            } else {
                view = b();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.u0) {
            view = b();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.u0) {
            view = a();
        }
        if ((view.getTag() instanceof SparseArray) && (c1276b = (C1276b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.f53618i && i2 + 1 >= getCount();
            boolean z2 = i2 == this.o;
            c(c1276b, postData, !z, i2 == 0, z2);
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
        this.f53615f = onClickListener;
    }

    public void i(a2 a2Var) {
        this.k = a2Var;
    }

    public void j(int i2, boolean z) {
        this.f53616g = i2;
        this.f53617h = z;
    }
}
