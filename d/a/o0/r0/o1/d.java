package d.a.o0.r0.o1;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.SearchMajorActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
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
public class d extends d.a.o0.r0.o1.a {
    public EditText A;
    public ImageView B;
    public View C;
    public View D;
    public RankStarView E;
    public RankStarView F;
    public Editable G;
    public Editable H;
    public TextView I;
    public TextView J;
    public TbImageView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public EditText z;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getAction() != 2) {
                return false;
            }
            l.x(d.this.f62986e, view);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.b {
        public b() {
        }

        @Override // d.a.o0.r0.o1.c.b
        public void a(InputMethodManager inputMethodManager) {
            if (inputMethodManager != null) {
                d dVar = d.this;
                dVar.f62986e.HidenSoftKeyPad(inputMethodManager, dVar.z);
                d dVar2 = d.this;
                dVar2.f62986e.HidenSoftKeyPad(inputMethodManager, dVar2.A);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.this.G = editable;
            if (d.this.G.length() <= 500) {
                d.this.I.setVisibility(4);
            } else {
                d.this.I.setText((500 - d.this.G.length()) + "/500");
                d.this.I.setVisibility(0);
            }
            d.this.B();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* renamed from: d.a.o0.r0.o1.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1585d implements TextWatcher {
        public C1585d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.this.H = editable;
            if (d.this.H.length() <= 500) {
                d.this.J.setVisibility(4);
            } else {
                d.this.J.setText((500 - d.this.H.length()) + "/500");
                d.this.J.setVisibility(0);
            }
            d.this.B();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getId() == R.id.university_comment) {
                d dVar = d.this;
                if (dVar.A(dVar.z)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getId() == R.id.university_subject_comment) {
                d dVar = d.this;
                if (dVar.A(dVar.A)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements y.d {
        public g() {
        }

        @Override // d.a.o0.e3.y.d
        public void onDraftLoaded(WriteData writeData) {
            if (writeData == null) {
                return;
            }
            try {
                d.this.F.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
            } catch (NumberFormatException unused) {
                d.this.F.setStarCount(0.0f);
            }
            try {
                d.this.E.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
            } catch (NumberFormatException unused2) {
                d.this.E.setStarCount(0.0f);
            }
            d.this.v.setText(writeData.getmUniversitySubjectContent());
            d.this.z.setText(writeData.getmUniversityComment());
            d.this.A.setText(writeData.getmUniversitySubjectComment());
        }
    }

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    public final boolean A(EditText editText) {
        int scrollY = editText.getScrollY();
        int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height - 1;
    }

    public final void B() {
        if (!TextUtils.isEmpty(this.G) && this.G.length() >= 20 && !TextUtils.isEmpty(this.H) && this.H.length() >= 20 && !this.f62986e.getString(R.string.select_subject).equals(this.v.getText()) && this.G.length() <= 500 && this.H.length() <= 500) {
            this.k.setAlpha(1.0f);
        } else {
            this.k.setAlpha(0.5f);
        }
    }

    public final String F() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.F.getStarCount();
        int starCount2 = this.E.getStarCount();
        if (starCount != 0) {
            arrayList.add(new HeadItem("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new HeadItem("专业", this.v.getText().toString(), 1));
        if (starCount2 != 0) {
            arrayList.add(new HeadItem("专业评分", String.valueOf(starCount), 2));
        }
        return this.n.toJson(arrayList);
    }

    public final String G(List<String> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append(str);
                sb.append(" ");
            }
            return sb.toString();
        }
        return null;
    }

    @Override // d.a.o0.r0.o1.a
    public void c() {
        ForumWriteData forumWriteData = this.f62987f;
        if (forumWriteData == null) {
            return;
        }
        y.l(String.valueOf(forumWriteData.forumId), new g());
    }

    @Override // d.a.o0.r0.o1.a
    public void f() {
        View inflate = LayoutInflater.from(this.f62986e).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.f62988g = inflate;
        this.f62989h = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
        this.q = (TbImageView) this.f62988g.findViewById(R.id.university_icon);
        this.r = (TextView) this.f62988g.findViewById(R.id.university_name);
        this.s = (TextView) this.f62988g.findViewById(R.id.university_desc);
        this.t = (TextView) this.f62988g.findViewById(R.id.university_grade);
        this.u = (TextView) this.f62988g.findViewById(R.id.university_subject);
        this.v = (TextView) this.f62988g.findViewById(R.id.university_subject_content);
        this.B = (ImageView) this.f62988g.findViewById(R.id.subject_right_arrow);
        this.w = (TextView) this.f62988g.findViewById(R.id.university_subject_grade);
        this.x = (TextView) this.f62988g.findViewById(R.id.university_comment_title);
        this.y = (TextView) this.f62988g.findViewById(R.id.subject_comment_title);
        EditText editText = (EditText) this.f62988g.findViewById(R.id.university_comment);
        this.z = editText;
        editText.setLineSpacing(l.g(this.f62986e, R.dimen.tbds16), 1.0f);
        EditText editText2 = (EditText) this.f62988g.findViewById(R.id.university_subject_comment);
        this.A = editText2;
        editText2.setLineSpacing(l.g(this.f62986e, R.dimen.tbds16), 1.0f);
        this.I = (TextView) this.f62988g.findViewById(R.id.university_comment_counter);
        this.J = (TextView) this.f62988g.findViewById(R.id.university_subject_comment_counter);
        this.D = this.f62988g.findViewById(R.id.select_subject_layout);
        RankStarView rankStarView = (RankStarView) this.f62988g.findViewById(R.id.university_grade_star);
        this.E = rankStarView;
        rankStarView.setClickable(true);
        this.E.setStarSpacing(l.g(this.f62986e, R.dimen.tbds24));
        RankStarView rankStarView2 = (RankStarView) this.f62988g.findViewById(R.id.university_subject_grade_star);
        this.F = rankStarView2;
        rankStarView2.setClickable(true);
        this.F.setStarSpacing(l.g(this.f62986e, R.dimen.tbds24));
        this.C = this.f62988g.findViewById(R.id.divider);
        SerializableItemInfo serializableItemInfo = this.l;
        if (serializableItemInfo != null) {
            this.s.setText(G(serializableItemInfo.getTags()));
            this.r.setText(this.l.getName());
            this.q.U(this.l.icon_url, 10, false);
        }
        this.q.setPlaceHolder(2);
        this.q.setPageId(this.f62986e.getUniqueId());
        this.q.setConrers(15);
        this.q.setRadius(l.g(this.f62986e, R.dimen.tbds10));
        this.f62988g.findViewById(R.id.scroll_view).setOnTouchListener(new a());
        this.m.h(new b());
    }

    @Override // d.a.o0.r0.o1.a
    public void h() {
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.z.addTextChangedListener(new c());
        this.A.addTextChangedListener(new C1585d());
        this.z.setOnTouchListener(new e());
        this.A.setOnTouchListener(new f());
    }

    @Override // d.a.o0.r0.o1.a
    public void i(int i2, int i3, Intent intent) {
        if (i3 == -1 && intent != null && i2 == 25047) {
            String stringExtra = intent.getStringExtra(IntentConfig.SEARCH_MAJOR_NAME);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.v.setText(stringExtra);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.B, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            B();
        }
    }

    @Override // d.a.o0.r0.o1.a
    public void j() {
        super.j();
        SkinManager.setBackgroundColor(this.C, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105);
        if (this.f62986e.getString(R.string.select_subject).equals(this.v.getText())) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.B, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.B, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.x, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.y, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.z, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.A, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.I, R.color.CAM_X0301);
        SkinManager.setViewTextColor(this.J, R.color.CAM_X0301);
        this.z.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
        this.A.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
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
        int starCount = this.F.getStarCount();
        writeData.setmUniversityGrade(String.valueOf(this.E.getStarCount()));
        writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
        writeData.setmUniversitySubjectContent(this.v.getText().toString());
        writeData.setmUniversityComment(this.z.getText().toString());
        writeData.setmUniversitySubjectComment(this.A.getText().toString());
        y.s(String.valueOf(this.f62987f.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.j) {
            m();
        } else if (view == this.D) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchMajorActivityConfig(this.f62986e, 25047)));
        } else if (view == this.k) {
            if (!TextUtils.isEmpty(this.G) && !TextUtils.isEmpty(this.H) && !this.f62986e.getString(R.string.select_subject).equals(this.v.getText())) {
                if (this.G.length() < 20) {
                    l.L(this.f62986e, R.string.university_comment_size_error_tip);
                    return;
                } else if (this.H.length() < 20) {
                    l.L(this.f62986e, R.string.subject_comment_size_error_tip);
                    return;
                } else if (this.G.length() > 500) {
                    l.L(this.f62986e, R.string.university_comment_lenght_error_tip);
                    return;
                } else if (this.H.length() > 500) {
                    l.L(this.f62986e, R.string.subject_comment_lenght_error_tip);
                    return;
                } else {
                    this.m.g("学校评价：" + ((Object) this.G) + "\n专业评价：" + ((Object) this.H), F(), this.f62987f);
                    return;
                }
            }
            l.L(this.f62986e, R.string.university_comment_must_write_tip);
        }
    }
}
