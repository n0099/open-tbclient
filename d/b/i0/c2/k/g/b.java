package d.b.i0.c2.k.g;

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
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f53053e;
    public a2 k;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f53054f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f53055g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53056h = false;
    public boolean i = false;
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
        public int f53057a = 3;

        /* renamed from: b  reason: collision with root package name */
        public View f53058b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f53059c;

        /* renamed from: d  reason: collision with root package name */
        public View f53060d;

        public a(Context context, View view) {
            this.f53060d = view;
            this.f53058b = view.findViewById(R.id.divider_line);
            TextView textView = (TextView) view.findViewById(R.id.center_reply_text);
            this.f53059c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i) {
            if (i != this.f53057a) {
                SkinManager.setBackgroundColor(this.f53058b, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f53059c, R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.f53059c, R.color.CAM_X0201);
                this.f53059c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.f53057a = i;
        }
    }

    /* renamed from: d.b.i0.c2.k.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1167b {

        /* renamed from: a  reason: collision with root package name */
        public int f53061a = 3;

        /* renamed from: b  reason: collision with root package name */
        public View f53062b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f53063c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f53064d;

        /* renamed from: e  reason: collision with root package name */
        public TbRichTextView f53065e;

        /* renamed from: f  reason: collision with root package name */
        public View f53066f;
    }

    public b(Context context) {
        this.f53053e = null;
        this.f53053e = context;
    }

    public View a() {
        View inflate = LayoutInflater.from(this.f53053e).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.f53053e, inflate));
        return inflate;
    }

    public View b() {
        C1167b c1167b = new C1167b();
        View inflate = LayoutInflater.from(this.f53053e).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c1167b.f53062b = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        c1167b.f53063c = linearLayout;
        if (this.l) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.topMargin = l.g(this.f53053e, R.dimen.ds8);
            layoutParams.bottomMargin = l.g(this.f53053e, R.dimen.ds8);
            c1167b.f53063c.setLayoutParams(layoutParams);
        }
        c1167b.f53064d = (TextView) inflate.findViewById(R.id.manage_btn);
        c1167b.f53065e = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c1167b.f53066f = inflate.findViewById(R.id.divide_bottom_view);
        c1167b.f53065e.getLayoutStrategy().t();
        if (!this.l) {
            c1167b.f53065e.getLayoutStrategy().o(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c1167b.f53065e.getLayoutStrategy().j(0);
            c1167b.f53065e.getLayoutStrategy().l(l.g(this.f53053e, R.dimen.tbds20));
            c1167b.f53065e.getLayoutStrategy().m(l.g(this.f53053e, R.dimen.tbds14));
            c1167b.f53065e.setMaxLines(4);
            c1167b.f53065e.setTextEllipsize(TextUtils.TruncateAt.END);
        }
        c1167b.f53065e.setSubPbPost(true);
        c1167b.f53065e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        c1167b.f53065e.setTextSize(TbConfig.getContentSizeOfLzl());
        c1167b.f53065e.setTextCenter(true);
        c1167b.f53065e.setOnClickListener(this.q);
        c1167b.f53064d.setOnClickListener(this.f53054f);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c1167b);
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
    public void c(C1167b c1167b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        if (c1167b == null || postData == null) {
            return;
        }
        boolean z7 = true;
        boolean z8 = false;
        if (!postData.a0) {
            Context context = this.f53053e;
            if (context instanceof d.b.i0.c2.k.a) {
                d.b.i0.c2.k.a aVar = (d.b.i0.c2.k.a) context;
                postData.x0(aVar.getPageContext(), postData.s() != null && aVar.isHost(postData.s().getUserId()));
            }
        }
        if (z3) {
            SkinManager.setBackgroundColor(c1167b.f53062b, R.color.CAM_X0204);
        } else {
            c1167b.f53062b.setBackgroundResource(0);
        }
        if (postData.Y()) {
            c1167b.f53066f.setVisibility(0);
        } else {
            c1167b.f53066f.setVisibility(8);
        }
        c1167b.f53065e.setPadding(0, 0, 0, 0);
        if (postData.s() != null) {
            String name_show = postData.s().getName_show();
            String userId = postData.s().getUserId();
            SparseArray sparseArray2 = (SparseArray) c1167b.f53062b.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                c1167b.f53062b.setTag(sparseArray2);
                c1167b.f53065e.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_photo_username, name_show);
            sparseArray2.put(R.id.tag_photo_userid, userId);
            sparseArray2.put(R.id.tag_clip_board, postData);
            sparseArray2.put(R.id.tag_is_subpb, Boolean.TRUE);
        }
        c1167b.f53065e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
        c1167b.f53065e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
        d(postData, this.l);
        TbRichText J = postData.J();
        if (J != null) {
            c1167b.f53065e.setVoiceViewRes(R.layout.voice_play_btn_new);
            c1167b.f53065e.setIsFromCDN(this.j);
            if (c1167b.f53061a != TbadkCoreApplication.getInst().getSkinType()) {
                J.isChanged = true;
            }
            c1167b.f53065e.setText(J);
        }
        String userId2 = postData.s().getUserId();
        int i = this.f53055g;
        if (i != 0) {
            z4 = (i == 1002 || i == 3) ? false : true;
            z5 = (this.f53055g == 3 || this.k.S1()) ? false : true;
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
        if (this.f53056h) {
            if (!this.k.S1()) {
                z5 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = true;
                } else {
                    z7 = z5;
                }
                c1167b.f53064d.setVisibility(8);
                sparseArray = (SparseArray) c1167b.f53062b.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    c1167b.f53062b.setTag(sparseArray);
                    c1167b.f53065e.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.n);
                if (!z4) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f53055g));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, postData.s().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.s().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.s().getPortrait());
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.D());
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.D());
                sparseArray.put(R.id.tag_clip_board, postData);
                if (!z6) {
                    if (this.k != null) {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.s().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.s().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.s().getName_show());
                        }
                        if (this.k.o0() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.k.o0());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.D());
                    }
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z7) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.f53055g));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z8));
                    sparseArray.put(R.id.tag_del_post_type, 2);
                    sparseArray.put(R.id.tag_del_post_id, postData.D());
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.V()));
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                if (this.l && z2 && this.m) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1167b.f53063c.getLayoutParams();
                    layoutParams.topMargin = l.g(this.f53053e, R.dimen.ds32);
                    layoutParams.bottomMargin = l.g(this.f53053e, R.dimen.ds8);
                    c1167b.f53063c.setLayoutParams(layoutParams);
                }
                if (this.l && !z2) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c1167b.f53063c.getLayoutParams();
                    layoutParams2.topMargin = l.g(this.f53053e, R.dimen.ds8);
                    layoutParams2.bottomMargin = l.g(this.f53053e, R.dimen.ds8);
                    c1167b.f53063c.setLayoutParams(layoutParams2);
                }
                c1167b.f53064d.setTag(sparseArray);
                c1167b.f53065e.setTag(sparseArray);
                c1167b.f53061a = TbadkCoreApplication.getInst().getSkinType();
                c1167b.f53065e.setOnLongClickListener(this.p);
            }
        }
        z6 = false;
        if (userId2 == null) {
        }
        z7 = z5;
        c1167b.f53064d.setVisibility(8);
        sparseArray = (SparseArray) c1167b.f53062b.getTag();
        if (sparseArray == null) {
        }
        sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.n);
        if (!z4) {
        }
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.D());
        sparseArray.put(R.id.tag_clip_board, postData);
        if (!z6) {
        }
        if (!z7) {
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c1167b.f53063c.getLayoutParams();
            layoutParams3.topMargin = l.g(this.f53053e, R.dimen.ds32);
            layoutParams3.bottomMargin = l.g(this.f53053e, R.dimen.ds8);
            c1167b.f53063c.setLayoutParams(layoutParams3);
        }
        if (this.l) {
            LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c1167b.f53063c.getLayoutParams();
            layoutParams22.topMargin = l.g(this.f53053e, R.dimen.ds8);
            layoutParams22.bottomMargin = l.g(this.f53053e, R.dimen.ds8);
            c1167b.f53063c.setLayoutParams(layoutParams22);
        }
        c1167b.f53064d.setTag(sparseArray);
        c1167b.f53065e.setTag(sparseArray);
        c1167b.f53061a = TbadkCoreApplication.getInst().getSkinType();
        c1167b.f53065e.setOnLongClickListener(this.p);
    }

    public final void d(PostData postData, boolean z) {
        TbRichText J;
        SpannableStringBuilder A;
        String str;
        if (postData == null || (J = postData.J()) == null) {
            return;
        }
        ArrayList<TbRichTextData> u = J.u();
        if (ListUtils.isEmpty(u)) {
            return;
        }
        if (z) {
            TbRichTextData tbRichTextData = u.get(u.size() - 1);
            int type = tbRichTextData != null ? tbRichTextData.getType() : -1;
            if (type == 1) {
                String str2 = "   " + StringHelper.getFormatTime(postData.Q());
                if (u.size() > 1) {
                    if ((u.get(u.size() + (-2)) != null ? u.get(u.size() - 2).getType() : -1) != type) {
                        str2 = StringHelper.getFormatTime(postData.Q());
                    }
                }
                SpannableStringBuilder A2 = tbRichTextData.A();
                if (J.hasAppendTime && A2 != 0 && J.appendLength <= A2.length()) {
                    A2.delete(A2.length() - J.appendLength, A2.length());
                }
                str = StringHelper.forceLToR(str2);
                if (A2 != null) {
                    A2.append((CharSequence) str);
                }
                J.hasAppendTime = true;
                J.appendLength = str.length();
            } else if (J.hasAppendTime) {
                str = "";
            } else {
                String formatTime = StringHelper.getFormatTime(postData.Q());
                tbRichTextData = new TbRichTextData(1);
                String forceLToR = StringHelper.forceLToR(formatTime);
                tbRichTextData.s(forceLToR);
                J.hasAppendTime = true;
                J.appendLength = forceLToR.length();
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
        if (J.hasAppendTime && tbRichTextData2 != null && (A = tbRichTextData2.A()) != null && J.appendLength <= A.length()) {
            A.delete(A.length() - J.appendLength, A.length());
        }
        J.hasAppendTime = false;
        J.appendLength = 0;
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
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1167b c1167b;
        PostData postData = getItem(i) instanceof PostData ? (PostData) getItem(i) : null;
        if (view == null) {
            if (postData.getType() == PostData.t0) {
                view = a();
            } else {
                view = b();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.t0) {
            view = b();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.t0) {
            view = a();
        }
        if ((view.getTag() instanceof SparseArray) && (c1167b = (C1167b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.i && i + 1 >= getCount();
            boolean z2 = i == this.o;
            c(c1167b, postData, !z, i == 0, z2);
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
        this.f53054f = onClickListener;
    }

    public void i(a2 a2Var) {
        this.k = a2Var;
    }

    public void j(int i, boolean z) {
        this.f53055g = i;
        this.f53056h = z;
    }
}
