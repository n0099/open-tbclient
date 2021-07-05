package d.a.s0.a4.u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f57624e;

    /* renamed from: f  reason: collision with root package name */
    public AtListActivity f57625f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<MetaData> f57626g;

    /* renamed from: h  reason: collision with root package name */
    public TbCheckBox.b f57627h;

    /* renamed from: i  reason: collision with root package name */
    public c f57628i;
    public ViewGroup j;
    public boolean k;

    /* renamed from: d.a.s0.a4.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1322a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f57629a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f57630b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57631c;

        /* renamed from: d  reason: collision with root package name */
        public TbCheckBox f57632d;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, C1322a c1322a) {
            this(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void handlerItem(View view, MetaData metaData);
    }

    public a(AtListActivity atListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57628i = null;
        this.j = null;
        this.k = true;
        this.f57625f = atListActivity;
        this.f57624e = atListActivity.getPageContext().getContext();
        this.k = z;
    }

    public final b a(Object obj, MetaData metaData) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, metaData)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (obj == null) {
                bVar = b();
            } else {
                bVar = (b) obj;
            }
            c cVar = this.f57628i;
            if (cVar != null) {
                cVar.handlerItem(bVar.f57629a, metaData);
            }
            String avater = metaData.getAvater();
            bVar.f57631c.setText(metaData.getName_show());
            bVar.f57632d.setTagData(metaData);
            bVar.f57630b.setTag(avater);
            if (this.k) {
                bVar.f57632d.setVisibility(0);
            } else {
                bVar.f57632d.setVisibility(8);
            }
            bVar.f57630b.M(avater, 12, false);
            this.f57625f.getPageContext().getLayoutMode().k(skinType == 1);
            this.f57625f.getPageContext().getLayoutMode().j(bVar.f57629a);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.f57624e).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
            bVar.f57629a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.photo);
            bVar.f57630b = headImageView;
            headImageView.setIsRound(false);
            bVar.f57631c = (TextView) bVar.f57629a.findViewById(R.id.txt_user_name);
            TbCheckBox tbCheckBox = (TbCheckBox) bVar.f57629a.findViewById(R.id.ckb_select);
            bVar.f57632d = tbCheckBox;
            tbCheckBox.setBackgroundDrawableIdIsWebP(true);
            bVar.f57632d.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
            TbCheckBox.b bVar2 = this.f57627h;
            if (bVar2 != null) {
                bVar.f57632d.setStatedChangedListener(bVar2);
            }
            bVar.f57629a.setTag(bVar);
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public MetaData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            ArrayList<MetaData> arrayList = this.f57626g;
            if (arrayList != null && i2 < arrayList.size()) {
                return this.f57626g.get(i2);
            }
            return null;
        }
        return (MetaData) invokeI.objValue;
    }

    public void d(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f57627h = bVar;
        }
    }

    public void e(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f57626g = arrayList;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f57628i = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<MetaData> arrayList = this.f57626g;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            if (this.j == null) {
                this.j = viewGroup;
            }
            MetaData item = getItem(i2);
            if (item != null) {
                bVar = a(view != null ? view.getTag() : null, item);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                return bVar.f57629a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
