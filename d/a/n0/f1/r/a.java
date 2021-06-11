package d.a.n0.f1.r;

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
    public View f58374a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f58375b;

    /* renamed from: c  reason: collision with root package name */
    public View f58376c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f58377d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f58378e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressBar f58379f;

    /* renamed from: g  reason: collision with root package name */
    public View f58380g;

    /* renamed from: h  reason: collision with root package name */
    public View f58381h;

    /* renamed from: i  reason: collision with root package name */
    public AddGroupActivity f58382i;

    /* renamed from: d.a.n0.f1.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1380a implements TextWatcher {
        public C1380a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.f58380g.setTag(editable.toString().trim());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (a.this.f58377d.length() > 0) {
                a.this.f58378e.setVisibility(0);
            } else {
                a.this.f58378e.setVisibility(8);
            }
        }
    }

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.f58374a = null;
        this.f58375b = null;
        this.f58376c = null;
        this.f58377d = null;
        this.f58378e = null;
        this.f58379f = null;
        this.f58380g = null;
        this.f58382i = null;
        this.f58382i = addGroupActivity;
        initUI();
    }

    public void g(int i2) {
        this.f58382i.getLayoutMode().k(i2 == 1);
        this.f58382i.getLayoutMode().j(this.f58374a);
        this.f58375b.onChangeSkinType(this.f58382i.getPageContext(), i2);
    }

    public void h() {
        EditText editText = this.f58377d;
        if (editText != null) {
            editText.setText("");
        }
    }

    public View i() {
        return this.f58376c;
    }

    public final void initUI() {
        this.f58382i.setContentView(R.layout.im_add_group_activity);
        this.f58374a = this.f58382i.findViewById(R.id.addgroup_rootlayout);
        NavigationBar navigationBar = (NavigationBar) this.f58382i.findViewById(R.id.addgroup_navigationbar);
        this.f58375b = navigationBar;
        this.f58376c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58375b.setTitleText(this.f58382i.getResources().getString(R.string.add_group_title_main));
        EditText editText = (EditText) this.f58382i.findViewById(R.id.addgroup_input);
        this.f58377d = editText;
        editText.setInputType(2);
        this.f58378e = (ImageButton) this.f58382i.findViewById(R.id.addgroup_delbtn);
        this.f58380g = this.f58382i.findViewById(R.id.addgroup_searchbutton);
        this.f58381h = this.f58382i.findViewById(R.id.addgroup_vcode);
        this.f58377d.addTextChangedListener(new C1380a());
        this.f58380g = this.f58382i.findViewById(R.id.addgroup_searchbutton);
        this.f58379f = (ProgressBar) this.f58382i.findViewById(R.id.addgroup_progress);
        this.f58376c.setOnClickListener(this.f58382i);
        this.f58378e.setOnClickListener(this.f58382i);
        this.f58380g.setOnClickListener(this.f58382i);
        this.f58381h.setOnClickListener(this.f58382i);
        if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            return;
        }
        this.f58381h.setVisibility(8);
    }

    public View k() {
        return this.f58378e;
    }

    public View l() {
        return this.f58380g;
    }

    public View m() {
        return this.f58381h;
    }

    public void n(boolean z) {
        this.f58379f.setVisibility(z ? 0 : 8);
    }
}
