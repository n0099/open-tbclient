package d.a.q0.b2.d;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.b2.e.c;
/* loaded from: classes7.dex */
public class b extends d.a.d.k.e.a<c, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f55085a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55086b;

        /* renamed from: c  reason: collision with root package name */
        public View f55087c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, TextView textView, View view2) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, textView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55085a = 3;
            this.f55086b = textView;
            this.f55087c = view2;
        }

        public void b(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            this.f55086b.setText(cVar.f55134e);
            this.f55087c.setVisibility(cVar.f55135f ? 0 : 8);
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f55085a == i2) {
                return;
            }
            SkinManager.setViewTextColor(this.f55086b, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f55087c, R.color.CAM_X0204);
            this.f55085a = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.q0.b2.e.a.f55128b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: e0 */
    public a Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setOrientation(1);
            linearLayout.setPadding(l.g(viewGroup.getContext(), R.dimen.tbds44), 0, l.g(viewGroup.getContext(), R.dimen.tbds44), l.g(viewGroup.getContext(), R.dimen.tbds12));
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            View view = new View(viewGroup.getContext());
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, l.g(viewGroup.getContext(), R.dimen.tbds1)));
            TextView textView = new TextView(viewGroup.getContext());
            textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.CAM_X0105));
            textView.setTextSize(0, l.g(viewGroup.getContext(), R.dimen.tbds47));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setIncludeFontPadding(false);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(0, l.g(viewGroup.getContext(), R.dimen.tbds48), 0, 0);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            a aVar = new a(linearLayout, textView, view);
            aVar.c(TbadkCoreApplication.getInst().getSkinType());
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public View X(int i2, View view, ViewGroup viewGroup, c cVar, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, aVar})) == null) {
            if (cVar == null || aVar == null) {
                return null;
            }
            aVar.b(cVar);
            aVar.c(TbadkCoreApplication.getInst().getSkinType());
            return aVar.a();
        }
        return (View) invokeCommon.objValue;
    }
}
