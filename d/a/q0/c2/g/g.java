package d.a.q0.c2.g;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<ImageFileInfo> f55301e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedHashMap<String, ImageFileInfo> f55302f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.c0.b f55303g;

    /* renamed from: h  reason: collision with root package name */
    public BaseFragmentActivity f55304h;

    /* renamed from: i  reason: collision with root package name */
    public f f55305i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f55306e;

        public a(g gVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55306e = viewGroup;
        }

        @Override // d.a.p0.b0.b
        public void a(d.a.d.k.d.a aVar, String str, boolean z) {
            HeadImageView headImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (headImageView = (HeadImageView) this.f55306e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            headImageView.invalidate();
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f55307a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f55308b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f55309c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f55310d;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f55311e;

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
                this.f55311e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getTag(view.getId()) != null && (view.getTag(view.getId()) instanceof ImageFileInfo)) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) view.getTag(view.getId());
                    if (this.f55311e.f55310d.f55302f.containsKey(imageFileInfo.getFilePath())) {
                        this.f55311e.f55310d.f55302f.remove(imageFileInfo.getFilePath());
                        SkinManager.setBackgroundResource(this.f55311e.f55309c, R.drawable.ic_post_image_selected_n);
                        if (this.f55311e.f55310d.f55305i != null) {
                            this.f55311e.f55310d.f55305i.onUnChoose();
                        }
                    } else if (this.f55311e.f55310d.f55305i != null) {
                        if (this.f55311e.f55310d.f55305i.canChooseMore()) {
                            this.f55311e.f55310d.f55302f.put(imageFileInfo.getFilePath(), imageFileInfo);
                            SkinManager.setBackgroundResource(this.f55311e.f55309c, R.drawable.ic_post_image_selected_s);
                            this.f55311e.f55310d.f55305i.onChoose();
                            return;
                        }
                        Activity pageActivity = this.f55311e.f55310d.f55304h.getPageContext().getPageActivity();
                        if (!TextUtils.isEmpty(this.f55311e.f55310d.p)) {
                            BdToast.c(pageActivity, this.f55311e.f55310d.p).q();
                        } else {
                            BdToast.c(pageActivity, pageActivity.getText(R.string.face_group_add_pic_max)).q();
                        }
                    }
                }
            }
        }

        public b(g gVar) {
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
            this.f55310d = gVar;
        }

        public final void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55308b = (HeadImageView) view.findViewById(R.id.image);
                this.f55309c = (ImageView) view.findViewById(R.id.select_icon);
                view.setOnClickListener(new a(this));
            }
        }
    }

    public g(BaseFragmentActivity baseFragmentActivity, List<ImageFileInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55304h = baseFragmentActivity;
        this.f55301e = list;
        this.f55302f = new LinkedHashMap<>();
        this.j = (int) baseFragmentActivity.getResources().getDimension(R.dimen.ds220);
        int k = l.k(baseFragmentActivity.getPageContext().getPageActivity());
        this.k = k;
        this.l = (k - l.g(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds16)) / 3;
        int g2 = l.g(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds8) / 3;
        this.m = g2;
        this.n = (g2 * 2) + 1;
        this.f55303g = new d.a.p0.c0.b();
    }

    public void e(Map<String, ImageFileInfo> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            this.f55302f.putAll(map);
        }
    }

    public LinkedHashMap<String, ImageFileInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55302f : (LinkedHashMap) invokeV.objValue;
    }

    public d.a.p0.c0.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55303g : (d.a.p0.c0.b) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ImageFileInfo> list = this.f55301e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                bVar = new b(this);
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_album, (ViewGroup) null);
                bVar.b(view2);
                view2.setTag(bVar);
            } else {
                view2 = view;
                bVar = (b) view.getTag();
            }
            bVar.f55307a = view2;
            int paddingTop = view2.getPaddingTop();
            int i3 = i2 % 3;
            if (i3 == 0) {
                bVar.f55307a.setPadding(0, paddingTop, this.n, 0);
            } else if (i3 == 1) {
                View view3 = bVar.f55307a;
                int i4 = this.m;
                view3.setPadding(i4, paddingTop, i4, 0);
            } else {
                bVar.f55307a.setPadding(this.n, paddingTop, 0, 0);
            }
            bVar.f55308b.getLayoutParams().height = this.l;
            bVar.f55308b.setTag(null);
            bVar.f55308b.setRadius(1);
            bVar.f55308b.setDefaultResource(R.drawable.img_default_100);
            bVar.f55308b.M(null, 12, false);
            bVar.f55308b.invalidate();
            ImageFileInfo imageFileInfo = this.f55301e.get(i2);
            if (imageFileInfo != null) {
                imageFileInfo.clearPageActions();
                int i5 = this.j;
                imageFileInfo.addPageAction(d.a.p0.c0.g.d.g(i5, i5));
                d.a.d.k.d.a c2 = this.f55303g.c(imageFileInfo, false);
                bVar.f55308b.setTag(imageFileInfo.toCachedKey(false));
                if (c2 != null) {
                    bVar.f55308b.invalidate();
                } else {
                    this.f55303g.e(imageFileInfo, new a(this, viewGroup), false, this.o);
                }
                if (this.f55302f.containsKey(imageFileInfo.getFilePath())) {
                    SkinManager.setBackgroundResource(bVar.f55309c, R.drawable.ic_post_image_selected_s);
                } else {
                    SkinManager.setBackgroundResource(bVar.f55309c, R.drawable.ic_post_image_selected_n);
                }
                view2.setTag(view2.getId(), imageFileInfo);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: h */
    public ImageFileInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<ImageFileInfo> list = this.f55301e;
            if (list == null || i2 > list.size() - 1) {
                return null;
            }
            return this.f55301e.get(i2);
        }
        return (ImageFileInfo) invokeI.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f55305i = fVar;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.p = str;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = z;
        }
    }
}
