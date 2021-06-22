package d.a.o0.r0.o1;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import d.a.c.e.p.l;
import d.a.o0.e3.y;
import d.a.o0.r0.o1.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends d.a.o0.r0.o1.a {
    public TbImageView q;
    public TextView r;
    public TextView s;
    public View t;
    public RankStarView u;
    public EditText v;
    public TextView w;
    public Editable x;
    public static final int y = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    public static final int z = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    public static final int A = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    public static final int B = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    public static final int C = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    public static final int D = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    public static final int E = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getAction() != 2) {
                return false;
            }
            l.x(b.this.f62986e, view);
            return false;
        }
    }

    /* renamed from: d.a.o0.r0.o1.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1584b implements c.b {
        public C1584b() {
        }

        @Override // d.a.o0.r0.o1.c.b
        public void a(InputMethodManager inputMethodManager) {
            if (inputMethodManager != null) {
                b bVar = b.this;
                bVar.f62986e.HidenSoftKeyPad(inputMethodManager, bVar.v);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            b.this.x = editable;
            if (b.this.x.length() > 500) {
                b.this.w.setText(String.format(b.this.f62986e.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.x.length())));
                b.this.w.setVisibility(0);
            } else {
                b.this.w.setVisibility(8);
            }
            b.this.t();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements y.d {
        public d() {
        }

        @Override // d.a.o0.e3.y.d
        public void onDraftLoaded(WriteData writeData) {
            if (writeData == null) {
                return;
            }
            b.this.u.setStarCount(writeData.getOtherGrade());
            b.this.v.setText(writeData.getOtherComment());
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // d.a.o0.r0.o1.a
    public void c() {
        ForumWriteData forumWriteData = this.f62987f;
        if (forumWriteData == null) {
            return;
        }
        y.l(String.valueOf(forumWriteData.forumId), new d());
    }

    @Override // d.a.o0.r0.o1.a
    public void f() {
        View inflate = LayoutInflater.from(this.f62986e).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.f62988g = inflate;
        this.f62989h = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.q = (TbImageView) this.f62988g.findViewById(R.id.item_icon);
        this.r = (TextView) this.f62988g.findViewById(R.id.item_title);
        this.s = (TextView) this.f62988g.findViewById(R.id.item_tag);
        this.t = this.f62988g.findViewById(R.id.divider);
        this.u = (RankStarView) this.f62988g.findViewById(R.id.item_star);
        this.v = (EditText) this.f62988g.findViewById(R.id.other_comment);
        this.w = (TextView) this.f62988g.findViewById(R.id.word_counter);
        this.q.setPlaceHolder(2);
        this.q.setConrers(15);
        this.q.setRadius(l.g(this.f62986e, R.dimen.tbds10));
        this.u.setStarSpacing(l.g(this.f62986e, R.dimen.tbds24));
        this.u.setClickable(true);
        this.v.setLineSpacing(l.g(this.f62986e, R.dimen.tbds16), 1.0f);
        SerializableItemInfo serializableItemInfo = this.l;
        if (serializableItemInfo != null) {
            v(serializableItemInfo.getTags());
            this.r.setText(this.l.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            if (this.l.getIconSize() == 1.0d) {
                layoutParams.width = y;
                layoutParams.height = z;
            } else if (this.l.getIconSize() == 0.67d) {
                layoutParams.width = A;
                layoutParams.height = B;
            } else {
                layoutParams.width = C;
                layoutParams.height = D;
            }
            this.q.setLayoutParams(layoutParams);
            this.q.U(this.l.icon_url, 10, false);
            if (this.l.getScore() != null && this.l.getScore().isCommented == 1) {
                this.u.setStarCount(this.l.getScore().getCommentStar());
            }
        }
        this.f62988g.findViewById(R.id.scroll_view).setOnTouchListener(new a());
        this.m.h(new C1584b());
    }

    @Override // d.a.o0.r0.o1.a
    public void h() {
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.v.addTextChangedListener(new c());
    }

    @Override // d.a.o0.r0.o1.a
    public void j() {
        super.j();
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0109);
        this.u.e(TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0105);
        this.v.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0301);
        TbImageView tbImageView = this.q;
        if (tbImageView != null) {
            tbImageView.setPlaceHolder(2);
            this.q.invalidate();
        }
    }

    @Override // d.a.o0.r0.o1.a
    public void l() {
        if (this.f62987f == null) {
            return;
        }
        WriteData writeData = new WriteData();
        writeData.setOtherGrade(this.u.getStarCount());
        writeData.setOtherComment(this.v.getText().toString());
        y.s(String.valueOf(this.f62987f.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j) {
            m();
        } else if (view == this.k) {
            if (!TextUtils.isEmpty(this.x) && this.x.length() >= 20) {
                if (this.x.length() > 500) {
                    l.L(this.f62986e, R.string.other_comment_size_long_tip);
                    return;
                } else {
                    this.m.g(this.x.toString(), u(), this.f62987f);
                    return;
                }
            }
            l.L(this.f62986e, R.string.other_comment_size_short_tip);
        }
    }

    public final void t() {
        if (!TextUtils.isEmpty(this.x) && this.x.length() >= 20 && this.x.length() <= 500) {
            this.k.setAlpha(1.0f);
        } else {
            this.k.setAlpha(0.5f);
        }
    }

    public final String u() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HeadItem("", String.valueOf(this.u.getStarCount()), 2));
        return this.n.toJson(arrayList);
    }

    public final void v(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.s.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                spannableStringBuilder.append((CharSequence) list.get(i2));
                if (i2 != list.size() - 1) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                    spannableStringBuilder2.setSpan(new d.a.n0.r.f0.o.b(E), 0, spannableStringBuilder2.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                }
            }
            this.s.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            return;
        }
        this.s.setVisibility(8);
    }
}
