package d.a.q0.a4.u;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.editortools.EditorBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54948a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.e0.e f54949b;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f54950e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54950e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54950e.f54949b.I();
            }
        }
    }

    public g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54948a = tbPageContext;
    }

    public void b() {
        d.a.q0.e0.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f54949b) == null) {
            return;
        }
        eVar.I();
    }

    public void c(EditorTools editorTools) {
        EditorBar editorBar;
        View s;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editorTools) == null) || editorTools == null || (editorBar = editorTools.f13039e) == null || this.f54948a == null || (s = editorBar.s(26)) == null) {
            return;
        }
        if (this.f54949b == null) {
            d.a.q0.e0.e eVar = new d.a.q0.e0.e(this.f54948a, s);
            this.f54949b = eVar;
            eVar.g0(R.drawable.bg_tip_blue_down);
            this.f54949b.O(32);
            this.f54949b.L(2);
            this.f54949b.M(new a(this));
            int dimensionPixelSize = this.f54948a.getResources().getDimensionPixelSize(R.dimen.ds10);
            int dimensionPixelSize2 = this.f54948a.getResources().getDimensionPixelSize(R.dimen.ds24);
            int dimensionPixelSize3 = this.f54948a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f54949b.Z(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            this.f54949b.j0(0);
            this.f54949b.k0(-dimensionPixelSize3);
            this.f54949b.N(3000);
        }
        this.f54949b.m0(this.f54948a.getResources().getString(R.string.hot_topic_tip), "key_show_hottopic_tip");
    }
}
