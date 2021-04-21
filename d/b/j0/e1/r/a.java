package d.b.j0.e1.r;

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
import d.b.c.a.d;
/* loaded from: classes4.dex */
public class a extends d<AddGroupActivity> {

    /* renamed from: a  reason: collision with root package name */
    public View f55922a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f55923b;

    /* renamed from: c  reason: collision with root package name */
    public View f55924c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f55925d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f55926e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f55927f;

    /* renamed from: g  reason: collision with root package name */
    public View f55928g;

    /* renamed from: h  reason: collision with root package name */
    public View f55929h;
    public AddGroupActivity i;

    /* renamed from: d.b.j0.e1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1295a implements TextWatcher {
        public C1295a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.f55928g.setTag(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (a.this.f55925d.length() > 0) {
                a.this.f55926e.setVisibility(0);
            } else {
                a.this.f55926e.setVisibility(8);
            }
        }
    }

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.f55922a = null;
        this.f55923b = null;
        this.f55924c = null;
        this.f55925d = null;
        this.f55926e = null;
        this.f55927f = null;
        this.f55928g = null;
        this.i = null;
        this.i = addGroupActivity;
        initUI();
    }

    public void g(int i) {
        this.i.getLayoutMode().k(i == 1);
        this.i.getLayoutMode().j(this.f55922a);
        this.f55923b.onChangeSkinType(this.i.getPageContext(), i);
    }

    public void h() {
        EditText editText = this.f55925d;
        if (editText != null) {
            editText.setText("");
        }
    }

    public View i() {
        return this.f55924c;
    }

    public final void initUI() {
        this.i.setContentView(R.layout.im_add_group_activity);
        this.f55922a = this.i.findViewById(R.id.addgroup_rootlayout);
        NavigationBar navigationBar = (NavigationBar) this.i.findViewById(R.id.addgroup_navigationbar);
        this.f55923b = navigationBar;
        this.f55924c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55923b.setTitleText(this.i.getResources().getString(R.string.add_group_title_main));
        EditText editText = (EditText) this.i.findViewById(R.id.addgroup_input);
        this.f55925d = editText;
        editText.setInputType(2);
        this.f55926e = (ImageButton) this.i.findViewById(R.id.addgroup_delbtn);
        this.f55928g = this.i.findViewById(R.id.addgroup_searchbutton);
        this.f55929h = this.i.findViewById(R.id.addgroup_vcode);
        this.f55925d.addTextChangedListener(new C1295a());
        this.f55928g = this.i.findViewById(R.id.addgroup_searchbutton);
        this.f55927f = (ProgressBar) this.i.findViewById(R.id.addgroup_progress);
        this.f55924c.setOnClickListener(this.i);
        this.f55926e.setOnClickListener(this.i);
        this.f55928g.setOnClickListener(this.i);
        this.f55929h.setOnClickListener(this.i);
        if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            return;
        }
        this.f55929h.setVisibility(8);
    }

    public View k() {
        return this.f55926e;
    }

    public View l() {
        return this.f55928g;
    }

    public View m() {
        return this.f55929h;
    }

    public void n(boolean z) {
        this.f55927f.setVisibility(z ? 0 : 8);
    }
}
