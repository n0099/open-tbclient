package d.a.r0.b1.e;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.b1.e.a;
/* loaded from: classes9.dex */
public class e implements a.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f54924e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f54925f;

    /* renamed from: g  reason: collision with root package name */
    public int f54926g;

    /* renamed from: h  reason: collision with root package name */
    public ListView f54927h;

    public e(ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54926g = -16777216;
        this.f54927h = listView;
    }

    @Override // d.a.r0.b1.e.a.j
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ((ImageView) view).setImageDrawable(null);
            this.f54924e.recycle();
            this.f54924e = null;
        }
    }

    @Override // d.a.r0.b1.e.a.j
    public View b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            ListView listView = this.f54927h;
            View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f54927h.getFirstVisiblePosition());
            if (childAt == null) {
                return null;
            }
            childAt.setPressed(false);
            childAt.setDrawingCacheEnabled(true);
            this.f54924e = Bitmap.createBitmap(childAt.getDrawingCache());
            childAt.setDrawingCacheEnabled(false);
            if (this.f54925f == null) {
                this.f54925f = new ImageView(this.f54927h.getContext());
            }
            this.f54925f.setBackgroundColor(this.f54926g);
            this.f54925f.setPadding(0, 0, 0, 0);
            this.f54925f.setImageBitmap(this.f54924e);
            this.f54925f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
            return this.f54925f;
        }
        return (View) invokeI.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f54926g = i2;
        }
    }
}
