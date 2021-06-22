package d.a.o0.f1.r;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import d.a.c.a.d;
/* loaded from: classes4.dex */
public class a extends d<AddGroupActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f58499a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f58500b;

    /* renamed from: c  reason: collision with root package name */
    public View f58501c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f58502d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f58503e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f58504f;

    /* renamed from: g  reason: collision with root package name */
    public View f58505g;

    /* renamed from: h  reason: collision with root package name */
    public View f58506h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f58507i;

    /* renamed from: d.a.o0.f1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1384a implements TextWatcher {
        public C1384a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.f58505g.setTag(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (a.this.f58502d.length() > 0) {
                a.this.f58503e.setVisibility(0);
            } else {
                a.this.f58503e.setVisibility(8);
            }
        }
    }

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.f58499a = null;
        this.f58500b = null;
        this.f58501c = null;
        this.f58502d = null;
        this.f58503e = null;
        this.f58504f = null;
        this.f58505g = null;
        this.f58507i = null;
        this.f58507i = addGroupActivity;
        initUI();
    }

    public void g(int i2) {
        this.f58507i.getLayoutMode().k(i2 == 1);
        this.f58507i.getLayoutMode().j(this.f58499a);
        this.f58500b.onChangeSkinType(this.f58507i.getPageContext(), i2);
    }

    public void h() {
        EditText editText = this.f58502d;
        if (editText != null) {
            editText.setText("");
        }
    }

    public View i() {
        return this.f58501c;
    }

    public final void initUI() {
        this.f58507i.setContentView(R.layout.im_add_group_activity);
        this.f58499a = this.f58507i.findViewById(R.id.addgroup_rootlayout);
        NavigationBar navigationBar = (NavigationBar) this.f58507i.findViewById(R.id.addgroup_navigationbar);
        this.f58500b = navigationBar;
        this.f58501c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58500b.setTitleText(this.f58507i.getResources().getString(R.string.add_group_title_main));
        EditText editText = (EditText) this.f58507i.findViewById(R.id.addgroup_input);
        this.f58502d = editText;
        editText.setInputType(2);
        this.f58503e = (ImageButton) this.f58507i.findViewById(R.id.addgroup_delbtn);
        this.f58505g = this.f58507i.findViewById(R.id.addgroup_searchbutton);
        this.f58506h = this.f58507i.findViewById(R.id.addgroup_vcode);
        this.f58502d.addTextChangedListener(new C1384a());
        this.f58505g = this.f58507i.findViewById(R.id.addgroup_searchbutton);
        this.f58504f = (ProgressBar) this.f58507i.findViewById(R.id.addgroup_progress);
        this.f58501c.setOnClickListener(this.f58507i);
        this.f58503e.setOnClickListener(this.f58507i);
        this.f58505g.setOnClickListener(this.f58507i);
        this.f58506h.setOnClickListener(this.f58507i);
        if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            return;
        }
        this.f58506h.setVisibility(8);
    }

    public View k() {
        return this.f58503e;
    }

    public View l() {
        return this.f58505g;
    }

    public View m() {
        return this.f58506h;
    }

    public void n(boolean z) {
        this.f58504f.setVisibility(z ? 0 : 8);
    }
}
