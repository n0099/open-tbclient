package d.a.j0.e1.r;

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
    public View f53788a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f53789b;

    /* renamed from: c  reason: collision with root package name */
    public View f53790c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f53791d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f53792e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f53793f;

    /* renamed from: g  reason: collision with root package name */
    public View f53794g;

    /* renamed from: h  reason: collision with root package name */
    public View f53795h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f53796i;

    /* renamed from: d.a.j0.e1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1234a implements TextWatcher {
        public C1234a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.f53794g.setTag(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (a.this.f53791d.length() > 0) {
                a.this.f53792e.setVisibility(0);
            } else {
                a.this.f53792e.setVisibility(8);
            }
        }
    }

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.f53788a = null;
        this.f53789b = null;
        this.f53790c = null;
        this.f53791d = null;
        this.f53792e = null;
        this.f53793f = null;
        this.f53794g = null;
        this.f53796i = null;
        this.f53796i = addGroupActivity;
        initUI();
    }

    public void g(int i2) {
        this.f53796i.getLayoutMode().k(i2 == 1);
        this.f53796i.getLayoutMode().j(this.f53788a);
        this.f53789b.onChangeSkinType(this.f53796i.getPageContext(), i2);
    }

    public void h() {
        EditText editText = this.f53791d;
        if (editText != null) {
            editText.setText("");
        }
    }

    public final void initUI() {
        this.f53796i.setContentView(R.layout.im_add_group_activity);
        this.f53788a = this.f53796i.findViewById(R.id.addgroup_rootlayout);
        NavigationBar navigationBar = (NavigationBar) this.f53796i.findViewById(R.id.addgroup_navigationbar);
        this.f53789b = navigationBar;
        this.f53790c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f53789b.setTitleText(this.f53796i.getResources().getString(R.string.add_group_title_main));
        EditText editText = (EditText) this.f53796i.findViewById(R.id.addgroup_input);
        this.f53791d = editText;
        editText.setInputType(2);
        this.f53792e = (ImageButton) this.f53796i.findViewById(R.id.addgroup_delbtn);
        this.f53794g = this.f53796i.findViewById(R.id.addgroup_searchbutton);
        this.f53795h = this.f53796i.findViewById(R.id.addgroup_vcode);
        this.f53791d.addTextChangedListener(new C1234a());
        this.f53794g = this.f53796i.findViewById(R.id.addgroup_searchbutton);
        this.f53793f = (ProgressBar) this.f53796i.findViewById(R.id.addgroup_progress);
        this.f53790c.setOnClickListener(this.f53796i);
        this.f53792e.setOnClickListener(this.f53796i);
        this.f53794g.setOnClickListener(this.f53796i);
        this.f53795h.setOnClickListener(this.f53796i);
        if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            return;
        }
        this.f53795h.setVisibility(8);
    }

    public View j() {
        return this.f53790c;
    }

    public View k() {
        return this.f53792e;
    }

    public View l() {
        return this.f53794g;
    }

    public View m() {
        return this.f53795h;
    }

    public void n(boolean z) {
        this.f53793f.setVisibility(z ? 0 : 8);
    }
}
