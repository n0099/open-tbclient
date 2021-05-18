package d.a.k0.e1.r;

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
    public View f54495a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f54496b;

    /* renamed from: c  reason: collision with root package name */
    public View f54497c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f54498d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f54499e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f54500f;

    /* renamed from: g  reason: collision with root package name */
    public View f54501g;

    /* renamed from: h  reason: collision with root package name */
    public View f54502h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f54503i;

    /* renamed from: d.a.k0.e1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1306a implements TextWatcher {
        public C1306a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.f54501g.setTag(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (a.this.f54498d.length() > 0) {
                a.this.f54499e.setVisibility(0);
            } else {
                a.this.f54499e.setVisibility(8);
            }
        }
    }

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.f54495a = null;
        this.f54496b = null;
        this.f54497c = null;
        this.f54498d = null;
        this.f54499e = null;
        this.f54500f = null;
        this.f54501g = null;
        this.f54503i = null;
        this.f54503i = addGroupActivity;
        initUI();
    }

    public void g(int i2) {
        this.f54503i.getLayoutMode().k(i2 == 1);
        this.f54503i.getLayoutMode().j(this.f54495a);
        this.f54496b.onChangeSkinType(this.f54503i.getPageContext(), i2);
    }

    public void h() {
        EditText editText = this.f54498d;
        if (editText != null) {
            editText.setText("");
        }
    }

    public final void initUI() {
        this.f54503i.setContentView(R.layout.im_add_group_activity);
        this.f54495a = this.f54503i.findViewById(R.id.addgroup_rootlayout);
        NavigationBar navigationBar = (NavigationBar) this.f54503i.findViewById(R.id.addgroup_navigationbar);
        this.f54496b = navigationBar;
        this.f54497c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54496b.setTitleText(this.f54503i.getResources().getString(R.string.add_group_title_main));
        EditText editText = (EditText) this.f54503i.findViewById(R.id.addgroup_input);
        this.f54498d = editText;
        editText.setInputType(2);
        this.f54499e = (ImageButton) this.f54503i.findViewById(R.id.addgroup_delbtn);
        this.f54501g = this.f54503i.findViewById(R.id.addgroup_searchbutton);
        this.f54502h = this.f54503i.findViewById(R.id.addgroup_vcode);
        this.f54498d.addTextChangedListener(new C1306a());
        this.f54501g = this.f54503i.findViewById(R.id.addgroup_searchbutton);
        this.f54500f = (ProgressBar) this.f54503i.findViewById(R.id.addgroup_progress);
        this.f54497c.setOnClickListener(this.f54503i);
        this.f54499e.setOnClickListener(this.f54503i);
        this.f54501g.setOnClickListener(this.f54503i);
        this.f54502h.setOnClickListener(this.f54503i);
        if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            return;
        }
        this.f54502h.setVisibility(8);
    }

    public View j() {
        return this.f54497c;
    }

    public View k() {
        return this.f54499e;
    }

    public View l() {
        return this.f54501g;
    }

    public View m() {
        return this.f54502h;
    }

    public void n(boolean z) {
        this.f54500f.setVisibility(z ? 0 : 8);
    }
}
