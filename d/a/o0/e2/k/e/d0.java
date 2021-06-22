package d.a.o0.e2.k.e;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.n0.r.s.l;
/* loaded from: classes5.dex */
public class d0 extends d.a.n0.r.s.j {
    public TbPageContext<?> A;
    public View.OnClickListener B;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes5.dex */
    public class a implements l.e {
        public a() {
        }

        @Override // d.a.n0.r.s.l.e
        public void onItemClick(d.a.n0.r.s.l lVar, int i2, View view) {
            d0.this.dismiss();
            d0.this.B.onClick(view);
        }
    }

    public d0(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.A = tbPageContext;
        this.B = onClickListener;
        q();
    }

    public TextView A() {
        return this.v;
    }

    public TextView B() {
        return this.y;
    }

    public TextView C() {
        return this.q;
    }

    public TextView D() {
        return this.u;
    }

    public TextView E() {
        return this.z;
    }

    public View F() {
        return g();
    }

    public void n(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public void o(SparseArray<Object> sparseArray, int i2, boolean z, d.a.o0.e2.h.r rVar) {
        TbPageContext<?> tbPageContext;
        int i3;
        if (sparseArray == null) {
            return;
        }
        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
        if (postData.q() != null) {
            boolean z2 = postData.q().hasAgree;
            int s = postData.s();
            if (z2 && s == 5) {
                tbPageContext = this.A;
                i3 = R.string.action_cancel_dislike;
            } else {
                tbPageContext = this.A;
                i3 = R.string.action_dislike;
            }
            String string = tbPageContext.getString(i3);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_clip_board, postData);
            u().setTag(sparseArray2);
            u().setVisibility(0);
            u().setText(string);
        }
        boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
        String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
        if (booleanValue) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            int i4 = R.id.tag_manage_user_identity;
            sparseArray3.put(i4, sparseArray.get(i4));
            int i5 = R.id.tag_forbid_user_name;
            sparseArray3.put(i5, sparseArray.get(i5));
            int i6 = R.id.tag_forbid_user_name_show;
            sparseArray3.put(i6, sparseArray.get(i6));
            int i7 = R.id.tag_forbid_user_portrait;
            sparseArray3.put(i7, sparseArray.get(i7));
            sparseArray3.put(R.id.tag_forbid_user_post_id, str);
            if (!d.a.o0.e2.k.e.e1.a.i(rVar) && booleanValue2) {
                sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                int i8 = R.id.tag_is_mem;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = R.id.tag_user_mute_mute_userid;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = R.id.tag_user_mute_mute_username;
                sparseArray3.put(i10, sparseArray.get(i10));
                int i11 = R.id.tag_user_mute_mute_nameshow;
                sparseArray3.put(i11, sparseArray.get(i11));
                int i12 = R.id.tag_user_mute_post_id;
                sparseArray3.put(i12, sparseArray.get(i12));
                int i13 = R.id.tag_user_mute_thread_id;
                sparseArray3.put(i13, sparseArray.get(i13));
            } else {
                sparseArray3.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            }
            if (booleanValue3) {
                sparseArray3.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                int i14 = R.id.tag_del_post_id;
                sparseArray3.put(i14, sparseArray.get(i14));
                int i15 = R.id.tag_del_post_type;
                sparseArray3.put(i15, sparseArray.get(i15));
                int i16 = R.id.tag_has_sub_post;
                sparseArray3.put(i16, sparseArray.get(i16));
                t().setVisibility(0);
            } else {
                sparseArray3.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                t().setVisibility(8);
            }
            y().setTag(sparseArray3);
            t().setTag(sparseArray3);
            y().setText(R.string.bar_manager);
            y().setVisibility(0);
        } else if (booleanValue3) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
            int i17 = R.id.tag_manage_user_identity;
            sparseArray4.put(i17, sparseArray.get(i17));
            sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
            int i18 = R.id.tag_del_post_id;
            sparseArray4.put(i18, sparseArray.get(i18));
            int i19 = R.id.tag_del_post_type;
            sparseArray4.put(i19, sparseArray.get(i19));
            int i20 = R.id.tag_has_sub_post;
            sparseArray4.put(i20, sparseArray.get(i20));
            y().setTag(sparseArray4);
            t().setTag(sparseArray4);
            y().setText(R.string.delete);
            t().setVisibility(0);
            if (i2 == 1002 && !booleanValue4) {
                t().setText(R.string.report_text);
            } else {
                t().setText(R.string.delete);
            }
            y().setVisibility(8);
        } else {
            y().setVisibility(8);
            t().setVisibility(8);
        }
        boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue6 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
        if (!d.a.o0.e2.k.e.e1.a.i(rVar) && !booleanValue6 && booleanValue5) {
            SparseArray sparseArray5 = new SparseArray();
            sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
            int i21 = R.id.tag_is_mem;
            sparseArray5.put(i21, sparseArray.get(i21));
            int i22 = R.id.tag_user_mute_mute_userid;
            sparseArray5.put(i22, sparseArray.get(i22));
            int i23 = R.id.tag_user_mute_mute_username;
            sparseArray5.put(i23, sparseArray.get(i23));
            int i24 = R.id.tag_user_mute_mute_nameshow;
            sparseArray5.put(i24, sparseArray.get(i24));
            int i25 = R.id.tag_user_mute_post_id;
            sparseArray5.put(i25, sparseArray.get(i25));
            int i26 = R.id.tag_user_mute_thread_id;
            sparseArray5.put(i26, sparseArray.get(i26));
            int i27 = R.id.tag_del_post_is_self;
            sparseArray5.put(i27, sparseArray.get(i27));
            int i28 = R.id.tag_del_post_type;
            sparseArray5.put(i28, sparseArray.get(i28));
            int i29 = R.id.tag_del_post_id;
            sparseArray5.put(i29, sparseArray.get(i29));
            int i30 = R.id.tag_manage_user_identity;
            sparseArray5.put(i30, sparseArray.get(i30));
            C().setTag(sparseArray5);
            C().setVisibility(0);
            y().setVisibility(8);
            C().setText(R.string.mute_option);
        } else {
            if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            }
            String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (z) {
                C().setVisibility(0);
                C().setTag(str2);
            } else {
                C().setVisibility(8);
            }
        }
        A().setVisibility(8);
        s().setVisibility(8);
        v().setVisibility(8);
        z().setVisibility(8);
        D().setVisibility(8);
        d.a.o0.e2.k.e.e1.a.l(this.x, postData, rVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x049c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p(SparseArray<Object> sparseArray, int i2, boolean z, boolean z2, d.a.o0.e2.h.r rVar) {
        boolean z3;
        boolean booleanValue;
        TbPageContext<?> tbPageContext;
        int i3;
        if (sparseArray != null) {
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            sparseArray2.put(R.id.tag_is_subpb, Boolean.FALSE);
            z().setTag(sparseArray2);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, (PostData) sparseArray.get(R.id.tag_clip_board));
            s().setTag(sparseArray3);
            boolean booleanValue2 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (booleanValue2) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                int i4 = R.id.tag_manage_user_identity;
                sparseArray4.put(i4, sparseArray.get(i4));
                int i5 = R.id.tag_forbid_user_name;
                sparseArray4.put(i5, sparseArray.get(i5));
                int i6 = R.id.tag_forbid_user_name_show;
                sparseArray4.put(i6, sparseArray.get(i6));
                int i7 = R.id.tag_forbid_user_portrait;
                sparseArray4.put(i7, sparseArray.get(i7));
                sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                if (!d.a.o0.e2.k.e.e1.a.i(rVar) && booleanValue3) {
                    sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i8 = R.id.tag_is_mem;
                    sparseArray4.put(i8, sparseArray.get(i8));
                    int i9 = R.id.tag_user_mute_mute_userid;
                    sparseArray4.put(i9, sparseArray.get(i9));
                    int i10 = R.id.tag_user_mute_mute_username;
                    sparseArray4.put(i10, sparseArray.get(i10));
                    int i11 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray4.put(i11, sparseArray.get(i11));
                    int i12 = R.id.tag_user_mute_post_id;
                    sparseArray4.put(i12, sparseArray.get(i12));
                    int i13 = R.id.tag_user_mute_thread_id;
                    sparseArray4.put(i13, sparseArray.get(i13));
                } else {
                    sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (booleanValue4) {
                    sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue5));
                    int i14 = R.id.tag_del_post_id;
                    sparseArray4.put(i14, sparseArray.get(i14));
                    int i15 = R.id.tag_del_post_type;
                    sparseArray4.put(i15, sparseArray.get(i15));
                    int i16 = R.id.tag_has_sub_post;
                    sparseArray4.put(i16, sparseArray.get(i16));
                    t().setVisibility(0);
                } else {
                    sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    t().setVisibility(8);
                }
                y().setTag(sparseArray4);
                t().setTag(sparseArray4);
                y().setText(R.string.bar_manager);
                y().setVisibility(0);
            } else if (booleanValue4) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                int i17 = R.id.tag_manage_user_identity;
                sparseArray5.put(i17, sparseArray.get(i17));
                sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue5));
                int i18 = R.id.tag_del_post_id;
                sparseArray5.put(i18, sparseArray.get(i18));
                int i19 = R.id.tag_del_post_type;
                sparseArray5.put(i19, sparseArray.get(i19));
                int i20 = R.id.tag_has_sub_post;
                sparseArray5.put(i20, sparseArray.get(i20));
                y().setTag(sparseArray5);
                t().setTag(sparseArray5);
                y().setText(R.string.delete);
                t().setVisibility(0);
                if (i2 == 1002 && !booleanValue5) {
                    t().setText(R.string.report_text);
                } else {
                    t().setText(R.string.delete);
                }
                y().setVisibility(8);
            } else {
                y().setVisibility(8);
                t().setVisibility(8);
            }
            boolean booleanValue6 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue7 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            if (!d.a.o0.e2.k.e.e1.a.i(rVar) && !booleanValue7 && booleanValue6) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                int i21 = R.id.tag_is_mem;
                sparseArray6.put(i21, sparseArray.get(i21));
                int i22 = R.id.tag_user_mute_mute_userid;
                sparseArray6.put(i22, sparseArray.get(i22));
                int i23 = R.id.tag_user_mute_mute_username;
                sparseArray6.put(i23, sparseArray.get(i23));
                int i24 = R.id.tag_user_mute_mute_nameshow;
                sparseArray6.put(i24, sparseArray.get(i24));
                int i25 = R.id.tag_user_mute_post_id;
                sparseArray6.put(i25, sparseArray.get(i25));
                int i26 = R.id.tag_user_mute_thread_id;
                sparseArray6.put(i26, sparseArray.get(i26));
                int i27 = R.id.tag_del_post_is_self;
                sparseArray6.put(i27, sparseArray.get(i27));
                int i28 = R.id.tag_del_post_type;
                sparseArray6.put(i28, sparseArray.get(i28));
                int i29 = R.id.tag_del_post_id;
                sparseArray6.put(i29, sparseArray.get(i29));
                int i30 = R.id.tag_manage_user_identity;
                sparseArray6.put(i30, sparseArray.get(i30));
                C().setTag(sparseArray6);
                C().setVisibility(0);
                y().setVisibility(8);
                C().setText(R.string.mute_option);
            } else {
                if (sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                String str2 = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
                if (z) {
                    C().setVisibility(0);
                    C().setTag(str2);
                } else {
                    C().setVisibility(8);
                }
            }
            boolean booleanValue8 = sparseArray.get(R.id.tag_should_hide_chudian_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_hide_chudian_visible)).booleanValue() : false;
            long longValue = sparseArray.get(R.id.tag_chudian_template_id) instanceof Long ? ((Long) sparseArray.get(R.id.tag_chudian_template_id)).longValue() : 0L;
            String str3 = sparseArray.get(R.id.tag_chudian_monitor_id) instanceof String ? (String) sparseArray.get(R.id.tag_chudian_monitor_id) : "";
            int intValue = sparseArray.get(R.id.tag_chudian_hide_day) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_chudian_hide_day)).intValue() : 0;
            if (booleanValue8) {
                A().setVisibility(0);
                A().setTag(R.id.tag_chudian_template_id, Long.valueOf(longValue));
                A().setTag(R.id.tag_chudian_monitor_id, str3);
                A().setTag(R.id.tag_chudian_hide_day, Integer.valueOf(intValue));
            } else {
                A().setVisibility(8);
            }
            if (sparseArray.get(R.id.tag_richtext_emotion) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_richtext_emotion)).booleanValue();
                if (this.A.getPageActivity() instanceof NewSubPbActivity) {
                    NewSubPbActivity newSubPbActivity = (NewSubPbActivity) this.A.getPageActivity();
                    if (z3 && newSubPbActivity.getSubPbModel() != null && newSubPbActivity.getSubPbModel().X() != null && newSubPbActivity.getSubPbModel().X().l() != null && !newSubPbActivity.getSubPbModel().X().l().V1()) {
                        z3 = true;
                    }
                }
                booleanValue = !(sparseArray.get(R.id.tag_richtext_image) instanceof Boolean) ? ((Boolean) sparseArray.get(R.id.tag_richtext_image)).booleanValue() : false;
                if (!z3) {
                    v().setVisibility(0);
                } else {
                    v().setVisibility(8);
                }
                if (!booleanValue) {
                    D().setVisibility(0);
                } else {
                    D().setVisibility(8);
                }
                if (z3 && !booleanValue) {
                    s().setVisibility(0);
                } else {
                    s().setVisibility(8);
                }
                u().setVisibility(8);
                if (z2) {
                    t().setVisibility(8);
                    y().setVisibility(8);
                    C().setVisibility(8);
                }
                if (d.a.n0.b.d.z()) {
                    if (postData != null) {
                        SparseArray sparseArray7 = new SparseArray();
                        sparseArray7.put(R.id.tag_load_sub_data, postData);
                        B().setTag(sparseArray7);
                        B().setText(R.string.action_reply);
                        B().setVisibility(0);
                    }
                    if (postData != null) {
                        SparseArray sparseArray8 = new SparseArray();
                        sparseArray8.put(R.id.tag_load_sub_data, postData);
                        sparseArray8.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.m0));
                        E().setTag(sparseArray8);
                        E().setText(R.string.action_share);
                        B().setVisibility(0);
                    }
                    if (postData.q() != null) {
                        boolean z4 = postData.q().hasAgree;
                        int s = postData.s();
                        if (z4 && s == 5) {
                            tbPageContext = this.A;
                            i3 = R.string.action_cancel_dislike;
                        } else {
                            tbPageContext = this.A;
                            i3 = R.string.action_dislike;
                        }
                        String string = tbPageContext.getString(i3);
                        SparseArray sparseArray9 = new SparseArray();
                        sparseArray9.put(R.id.tag_clip_board, postData);
                        u().setTag(sparseArray9);
                        u().setVisibility(0);
                        u().setText(string);
                    }
                }
                d.a.o0.e2.k.e.e1.a.l(this.x, postData, rVar);
            }
            z3 = false;
            if (!(sparseArray.get(R.id.tag_richtext_image) instanceof Boolean)) {
            }
            if (!z3) {
            }
            if (!booleanValue) {
            }
            if (z3) {
            }
            s().setVisibility(8);
            u().setVisibility(8);
            if (z2) {
            }
            if (d.a.n0.b.d.z()) {
            }
            d.a.o0.e2.k.e.e1.a.l(this.x, postData, rVar);
        }
    }

    public final void q() {
        a aVar = new a();
        if (d.a.n0.b.d.z()) {
            i(null, new String[]{this.A.getString(R.string.action_reply), this.A.getString(R.string.action_share), this.A.getString(R.string.action_dislike), this.A.getString(R.string.no_interesting), this.A.getString(R.string.save_to_emotion), this.A.getString(R.string.save_to_local), this.A.getString(R.string.copy), this.A.getString(R.string.mark), this.A.getString(R.string.report_text), this.A.getString(R.string.delete), this.A.getString(R.string.mute), this.A.getString(R.string.block_user)}, aVar);
            this.y = w(x(0));
            this.z = w(x(1));
            this.w = w(x(2));
            this.v = w(x(3));
            this.t = w(x(4));
            this.u = w(x(5));
            this.s = w(x(6));
            this.o = w(x(7));
            this.q = w(x(8));
            this.r = w(x(9));
            this.p = w(x(10));
            this.x = w(x(11));
            return;
        }
        i(null, new String[]{this.A.getString(R.string.action_dislike), this.A.getString(R.string.no_interesting), this.A.getString(R.string.save_to_emotion), this.A.getString(R.string.save_to_local), this.A.getString(R.string.copy), this.A.getString(R.string.mark), this.A.getString(R.string.report_text), this.A.getString(R.string.delete), this.A.getString(R.string.mute), this.A.getString(R.string.block_user)}, aVar);
        this.v = w(x(1));
        this.o = w(x(5));
        this.p = w(x(8));
        this.q = w(x(6));
        this.r = w(x(7));
        this.s = w(x(4));
        this.t = w(x(2));
        this.u = w(x(3));
        this.w = w(x(0));
        this.x = w(x(9));
    }

    public TextView r() {
        return this.x;
    }

    public TextView s() {
        return this.s;
    }

    public TextView t() {
        return this.r;
    }

    public TextView u() {
        return this.w;
    }

    public TextView v() {
        return this.t;
    }

    public final TextView w(View view) {
        return (TextView) view.findViewById(R.id.item_view);
    }

    public View x(int i2) {
        View findViewById;
        View view = this.f54052g;
        if (view != null && (view instanceof ViewGroup) && (findViewById = view.findViewById(R.id.content_view)) != null && (findViewById instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) findViewById;
            int childCount = viewGroup.getChildCount();
            if (i2 >= 0 && i2 <= childCount - 1) {
                return viewGroup.getChildAt(i2);
            }
        }
        return null;
    }

    public TextView y() {
        return this.p;
    }

    public TextView z() {
        return this.o;
    }
}
