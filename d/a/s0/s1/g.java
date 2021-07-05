package d.a.s0.s1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f65345a;

    /* renamed from: b  reason: collision with root package name */
    public TableLayout f65346b;

    /* renamed from: c  reason: collision with root package name */
    public View f65347c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f65348d;

    /* renamed from: e  reason: collision with root package name */
    public View f65349e;

    public g(TbPageContext<?> tbPageContext) {
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
        this.f65345a = tbPageContext;
    }

    public View a(c cVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, cVar, i2)) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f65345a.getPageActivity()).inflate(R.layout.search_topic_item, (ViewGroup) null);
            TextView textView = (TextView) linearLayout.findViewById(R.id.text_search_topic_item_text);
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.image_search_topic_item);
            if (cVar != null) {
                int c2 = cVar.c();
                imageView.setVisibility(0);
                imageView.setTag(Integer.valueOf(c2));
                g(imageView, c2, TbadkCoreApplication.getInst().getSkinType());
                textView.setText(e(cVar.b(), 8));
                linearLayout.setTag(cVar);
            } else {
                textView.setText(R.string.hot_forum_title_more);
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
                imageView.setVisibility(8);
            }
            b(linearLayout, i2, this.f65346b, 2);
            return linearLayout;
        }
        return (View) invokeLI.objValue;
    }

    public final void b(View view, int i2, TableLayout tableLayout, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Integer.valueOf(i2), tableLayout, Integer.valueOf(i3)}) == null) {
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(this.f65345a.getResources().getDimensionPixelSize(R.dimen.ds360), -2);
            if (i2 % i3 == 0) {
                TableRow tableRow = new TableRow(this.f65345a.getPageActivity());
                tableRow.addView(view, layoutParams);
                tableLayout.addView(tableRow);
            } else if (tableLayout.getChildCount() != 0) {
                ((TableRow) tableLayout.getChildAt(tableLayout.getChildCount() - 1)).addView(view, layoutParams);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f65346b.removeAllViews();
            this.f65347c.setVisibility(8);
            this.f65346b.setVisibility(8);
            this.f65348d.setVisibility(8);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View inflate = LayoutInflater.from(this.f65345a.getPageActivity()).inflate(R.layout.search_topic, (ViewGroup) null);
            this.f65347c = inflate;
            View findViewById = inflate.findViewById(R.id.titleTopDivider);
            this.f65349e = findViewById;
            findViewById.setVisibility(0);
            this.f65346b = (TableLayout) this.f65347c.findViewById(R.id.search_topic_layout);
            TextView textView = (TextView) this.f65347c.findViewById(R.id.square_search_fourm_header_text);
            this.f65348d = textView;
            textView.setText(this.f65345a.getResources().getString(R.string.hot_topic_title));
            return this.f65347c;
        }
        return (View) invokeV.objValue;
    }

    public final String e(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) {
            if (StringUtils.isNull(str)) {
                return "";
            }
            if (str.length() <= i2) {
                return str;
            }
            String substring = str.substring(0, i2 - 1);
            return substring + this.f65345a.getString(R.string.ellipsis);
        }
        return (String) invokeLI.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f65345a.getLayoutMode().j(this.f65347c);
            int childCount = this.f65346b.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                TableRow tableRow = (TableRow) this.f65346b.getChildAt(i3);
                int childCount2 = tableRow.getChildCount();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    LinearLayout linearLayout = (LinearLayout) tableRow.getChildAt(i4);
                    if (linearLayout.getChildCount() != 0) {
                        TextView textView = (TextView) linearLayout.getChildAt(0);
                        ImageView imageView = (ImageView) linearLayout.getChildAt(1);
                        if (i3 == childCount - 1 && i4 == childCount2 - 1) {
                            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
                        } else {
                            g(imageView, imageView.getTag() != null ? ((Integer) imageView.getTag()).intValue() : 0, i2);
                            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, i2);
                        }
                        SkinManager.setBackgroundResource(textView, R.drawable.square_search_item_bg, i2);
                    }
                }
            }
        }
    }

    public final void g(ImageView imageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048582, this, imageView, i2, i3) == null) || imageView == null) {
            return;
        }
        imageView.setImageDrawable(null);
        if (i2 == 1) {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_new, i3);
        } else if (i2 == 2) {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_hot, i3);
        } else if (i2 != 3) {
            imageView.setVisibility(8);
        } else {
            SkinManager.setImageResource(imageView, R.drawable.icon_topic_recommend, i3);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.f65348d == null) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f65348d.setText(str);
        } else {
            this.f65348d.setText(this.f65345a.getResources().getString(R.string.hot_topic_title));
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f65349e.setVisibility(z ? 0 : 8);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            f(TbadkCoreApplication.getInst().getSkinType());
            this.f65347c.setVisibility(0);
            this.f65346b.setVisibility(0);
            this.f65348d.setVisibility(0);
        }
    }
}
