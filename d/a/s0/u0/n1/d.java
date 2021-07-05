package d.a.s0.u0.n1;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.h3.y;
import d.a.s0.u0.n1.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends d.a.s0.u0.n1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66545e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66545e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 2) {
                    return false;
                }
                l.x(this.f66545e.f66525e, view);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f66546a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66546a = dVar;
        }

        @Override // d.a.s0.u0.n1.c.b
        public void a(InputMethodManager inputMethodManager) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, inputMethodManager) == null) || inputMethodManager == null) {
                return;
            }
            d dVar = this.f66546a;
            dVar.f66525e.HidenSoftKeyPad(inputMethodManager, dVar.z);
            d dVar2 = this.f66546a;
            dVar2.f66525e.HidenSoftKeyPad(inputMethodManager, dVar2.A);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66547e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66547e = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f66547e.G = editable;
                if (this.f66547e.G.length() <= 500) {
                    this.f66547e.I.setVisibility(4);
                } else {
                    this.f66547e.I.setText((500 - this.f66547e.G.length()) + "/500");
                    this.f66547e.I.setVisibility(0);
                }
                this.f66547e.B();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* renamed from: d.a.s0.u0.n1.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1743d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66548e;

        public C1743d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66548e = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f66548e.H = editable;
                if (this.f66548e.H.length() <= 500) {
                    this.f66548e.J.setVisibility(4);
                } else {
                    this.f66548e.J.setText((500 - this.f66548e.H.length()) + "/500");
                    this.f66548e.J.setVisibility(0);
                }
                this.f66548e.B();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66549e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66549e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view.getId() == R.id.university_comment) {
                    d dVar = this.f66549e;
                    if (dVar.A(dVar.z)) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        if (motionEvent.getAction() == 1) {
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66550e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66550e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view.getId() == R.id.university_subject_comment) {
                    d dVar = this.f66550e;
                    if (dVar.A(dVar.A)) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        if (motionEvent.getAction() == 1) {
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g implements y.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66551e;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66551e = dVar;
        }

        @Override // d.a.s0.h3.y.d
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            try {
                this.f66551e.F.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
            } catch (NumberFormatException unused) {
                this.f66551e.F.setStarCount(0.0f);
            }
            try {
                this.f66551e.E.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
            } catch (NumberFormatException unused2) {
                this.f66551e.E.setStarCount(0.0f);
            }
            this.f66551e.v.setText(writeData.getmUniversitySubjectContent());
            this.f66551e.z.setText(writeData.getmUniversityComment());
            this.f66551e.A.setText(writeData.getmUniversitySubjectComment());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (ForumWriteData) objArr2[1], (SerializableItemInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean A(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, editText)) == null) {
            int scrollY = editText.getScrollY();
            int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
            if (height == 0) {
                return false;
            }
            return scrollY > 0 || scrollY < height - 1;
        }
        return invokeL.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TextUtils.isEmpty(this.G) && this.G.length() >= 20 && !TextUtils.isEmpty(this.H) && this.H.length() >= 20 && !this.f66525e.getString(R.string.select_subject).equals(this.v.getText()) && this.G.length() <= 500 && this.H.length() <= 500) {
                this.k.setAlpha(1.0f);
            } else {
                this.k.setAlpha(0.5f);
            }
        }
    }

    public final String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public final String G(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
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
        return (String) invokeL.objValue;
    }

    @Override // d.a.s0.u0.n1.a
    public void c() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (forumWriteData = this.f66526f) == null) {
            return;
        }
        y.l(String.valueOf(forumWriteData.forumId), new g(this));
    }

    @Override // d.a.s0.u0.n1.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.f66525e).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
            this.f66527g = inflate;
            this.f66528h = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.q = (TbImageView) this.f66527g.findViewById(R.id.university_icon);
            this.r = (TextView) this.f66527g.findViewById(R.id.university_name);
            this.s = (TextView) this.f66527g.findViewById(R.id.university_desc);
            this.t = (TextView) this.f66527g.findViewById(R.id.university_grade);
            this.u = (TextView) this.f66527g.findViewById(R.id.university_subject);
            this.v = (TextView) this.f66527g.findViewById(R.id.university_subject_content);
            this.B = (ImageView) this.f66527g.findViewById(R.id.subject_right_arrow);
            this.w = (TextView) this.f66527g.findViewById(R.id.university_subject_grade);
            this.x = (TextView) this.f66527g.findViewById(R.id.university_comment_title);
            this.y = (TextView) this.f66527g.findViewById(R.id.subject_comment_title);
            EditText editText = (EditText) this.f66527g.findViewById(R.id.university_comment);
            this.z = editText;
            editText.setLineSpacing(l.g(this.f66525e, R.dimen.tbds16), 1.0f);
            EditText editText2 = (EditText) this.f66527g.findViewById(R.id.university_subject_comment);
            this.A = editText2;
            editText2.setLineSpacing(l.g(this.f66525e, R.dimen.tbds16), 1.0f);
            this.I = (TextView) this.f66527g.findViewById(R.id.university_comment_counter);
            this.J = (TextView) this.f66527g.findViewById(R.id.university_subject_comment_counter);
            this.D = this.f66527g.findViewById(R.id.select_subject_layout);
            RankStarView rankStarView = (RankStarView) this.f66527g.findViewById(R.id.university_grade_star);
            this.E = rankStarView;
            rankStarView.setClickable(true);
            this.E.setStarSpacing(l.g(this.f66525e, R.dimen.tbds24));
            RankStarView rankStarView2 = (RankStarView) this.f66527g.findViewById(R.id.university_subject_grade_star);
            this.F = rankStarView2;
            rankStarView2.setClickable(true);
            this.F.setStarSpacing(l.g(this.f66525e, R.dimen.tbds24));
            this.C = this.f66527g.findViewById(R.id.divider);
            SerializableItemInfo serializableItemInfo = this.l;
            if (serializableItemInfo != null) {
                this.s.setText(G(serializableItemInfo.getTags()));
                this.r.setText(this.l.getName());
                this.q.M(this.l.icon_url, 10, false);
            }
            this.q.setPlaceHolder(2);
            this.q.setPageId(this.f66525e.getUniqueId());
            this.q.setConrers(15);
            this.q.setRadius(l.g(this.f66525e, R.dimen.tbds10));
            this.f66527g.findViewById(R.id.scroll_view).setOnTouchListener(new a(this));
            this.m.h(new b(this));
        }
    }

    @Override // d.a.s0.u0.n1.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.z.addTextChangedListener(new c(this));
            this.A.addTextChangedListener(new C1743d(this));
            this.z.setOnTouchListener(new e(this));
            this.A.setOnTouchListener(new f(this));
        }
    }

    @Override // d.a.s0.u0.n1.a
    public void i(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, intent) == null) && i3 == -1 && intent != null && i2 == 25047) {
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

    @Override // d.a.s0.u0.n1.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.j();
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0105);
            if (this.f66525e.getString(R.string.select_subject).equals(this.v.getText())) {
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
    }

    @Override // d.a.s0.u0.n1.a
    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f66526f == null) {
            return;
        }
        WriteData writeData = new WriteData();
        int starCount = this.F.getStarCount();
        writeData.setmUniversityGrade(String.valueOf(this.E.getStarCount()));
        writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
        writeData.setmUniversitySubjectContent(this.v.getText().toString());
        writeData.setmUniversityComment(this.z.getText().toString());
        writeData.setmUniversitySubjectComment(this.A.getText().toString());
        y.s(String.valueOf(this.f66526f.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (view == this.j) {
                m();
            } else if (view == this.D) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchMajorActivityConfig(this.f66525e, 25047)));
            } else if (view == this.k) {
                if (!TextUtils.isEmpty(this.G) && !TextUtils.isEmpty(this.H) && !this.f66525e.getString(R.string.select_subject).equals(this.v.getText())) {
                    if (this.G.length() < 20) {
                        l.L(this.f66525e, R.string.university_comment_size_error_tip);
                        return;
                    } else if (this.H.length() < 20) {
                        l.L(this.f66525e, R.string.subject_comment_size_error_tip);
                        return;
                    } else if (this.G.length() > 500) {
                        l.L(this.f66525e, R.string.university_comment_lenght_error_tip);
                        return;
                    } else if (this.H.length() > 500) {
                        l.L(this.f66525e, R.string.subject_comment_lenght_error_tip);
                        return;
                    } else {
                        this.m.g("学校评价：" + ((Object) this.G) + "\n专业评价：" + ((Object) this.H), F(), this.f66526f);
                        return;
                    }
                }
                l.L(this.f66525e, R.string.university_comment_must_write_tip);
            }
        }
    }
}
