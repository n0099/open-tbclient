package d.a.s0.u0.n1;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
public class b extends d.a.s0.u0.n1.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView q;
    public TextView r;
    public TextView s;
    public View t;
    public RankStarView u;
    public EditText v;
    public TextView w;
    public Editable x;

    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66531e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66531e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 2) {
                    return false;
                }
                l.x(this.f66531e.f66525e, view);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: d.a.s0.u0.n1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1742b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66532a;

        public C1742b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66532a = bVar;
        }

        @Override // d.a.s0.u0.n1.c.b
        public void a(InputMethodManager inputMethodManager) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, inputMethodManager) == null) || inputMethodManager == null) {
                return;
            }
            b bVar = this.f66532a;
            bVar.f66525e.HidenSoftKeyPad(inputMethodManager, bVar.v);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66533e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66533e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f66533e.x = editable;
                if (this.f66533e.x.length() > 500) {
                    this.f66533e.w.setText(String.format(this.f66533e.f66525e.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - this.f66533e.x.length())));
                    this.f66533e.w.setVisibility(0);
                } else {
                    this.f66533e.w.setVisibility(8);
                }
                this.f66533e.t();
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
    public class d implements y.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66534e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66534e = bVar;
        }

        @Override // d.a.s0.h3.y.d
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            this.f66534e.u.setStarCount(writeData.getOtherGrade());
            this.f66534e.v.setText(writeData.getOtherComment());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-159540674, "Ld/a/s0/u0/n1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-159540674, "Ld/a/s0/u0/n1/b;");
                return;
            }
        }
        y = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        z = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        A = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
        B = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        C = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
        D = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
        E = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (ForumWriteData) objArr2[1], (SerializableItemInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.s0.u0.n1.a
    public void c() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumWriteData = this.f66526f) == null) {
            return;
        }
        y.l(String.valueOf(forumWriteData.forumId), new d(this));
    }

    @Override // d.a.s0.u0.n1.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.f66525e).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
            this.f66527g = inflate;
            this.f66528h = (NavigationBar) inflate.findViewById(R.id.navigation_bar);
            this.q = (TbImageView) this.f66527g.findViewById(R.id.item_icon);
            this.r = (TextView) this.f66527g.findViewById(R.id.item_title);
            this.s = (TextView) this.f66527g.findViewById(R.id.item_tag);
            this.t = this.f66527g.findViewById(R.id.divider);
            this.u = (RankStarView) this.f66527g.findViewById(R.id.item_star);
            this.v = (EditText) this.f66527g.findViewById(R.id.other_comment);
            this.w = (TextView) this.f66527g.findViewById(R.id.word_counter);
            this.q.setPlaceHolder(2);
            this.q.setConrers(15);
            this.q.setRadius(l.g(this.f66525e, R.dimen.tbds10));
            this.u.setStarSpacing(l.g(this.f66525e, R.dimen.tbds24));
            this.u.setClickable(true);
            this.v.setLineSpacing(l.g(this.f66525e, R.dimen.tbds16), 1.0f);
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
                this.q.M(this.l.icon_url, 10, false);
                if (this.l.getScore() != null && this.l.getScore().isCommented == 1) {
                    this.u.setStarCount(this.l.getScore().getCommentStar());
                }
            }
            this.f66527g.findViewById(R.id.scroll_view).setOnTouchListener(new a(this));
            this.m.h(new C1742b(this));
        }
    }

    @Override // d.a.s0.u0.n1.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.v.addTextChangedListener(new c(this));
        }
    }

    @Override // d.a.s0.u0.n1.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
    }

    @Override // d.a.s0.u0.n1.a
    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f66526f == null) {
            return;
        }
        WriteData writeData = new WriteData();
        writeData.setOtherGrade(this.u.getStarCount());
        writeData.setOtherComment(this.v.getText().toString());
        y.s(String.valueOf(this.f66526f.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view == this.j) {
                m();
            } else if (view == this.k) {
                if (!TextUtils.isEmpty(this.x) && this.x.length() >= 20) {
                    if (this.x.length() > 500) {
                        l.L(this.f66525e, R.string.other_comment_size_long_tip);
                        return;
                    } else {
                        this.m.g(this.x.toString(), u(), this.f66526f);
                        return;
                    }
                }
                l.L(this.f66525e, R.string.other_comment_size_short_tip);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!TextUtils.isEmpty(this.x) && this.x.length() >= 20 && this.x.length() <= 500) {
                this.k.setAlpha(1.0f);
            } else {
                this.k.setAlpha(0.5f);
            }
        }
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new HeadItem("", String.valueOf(this.u.getStarCount()), 2));
            return this.n.toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final void v(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                this.s.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    spannableStringBuilder.append((CharSequence) list.get(i2));
                    if (i2 != list.size() - 1) {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                        spannableStringBuilder2.setSpan(new d.a.r0.r.f0.q.b(E), 0, spannableStringBuilder2.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    }
                }
                this.s.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return;
            }
            this.s.setVisibility(8);
        }
    }
}
