package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class hs7 extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public x25 b;
    public LinkedList<ImageFileInfo> c;
    public int d;
    public int e;
    public c f;

    /* loaded from: classes6.dex */
    public class a implements t25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public a(hs7 hs7Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs7Var, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
        }

        @Override // com.repackage.t25
        public void a(um umVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, umVar, str, z) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(str)) == null || umVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends eg<um> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ String b;

        public b(hs7 hs7Var, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs7Var, viewGroup, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
        public void onLoaded(um umVar, String str, int i) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, umVar, str, i) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(this.b)) == null || umVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onClickImage(int i);

        void onDeleteImage(int i);
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public LinearLayout b;
        public ImageView c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public hs7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new x25();
        this.c = null;
        this.a = context;
        int k = li.k(context);
        this.e = k;
        this.d = ((k - (li.f(this.a, R.dimen.tbds44) * 2)) - (li.f(this.a, R.dimen.tbds10) * 2)) / 3;
    }

    public final void a(ImageFileInfo imageFileInfo, d dVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, imageFileInfo, dVar, viewGroup) == null) || imageFileInfo == null) {
            return;
        }
        int i = this.d;
        ImageOperation g = g35.g(i, i);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g);
        if (imageFileInfo.getImageType() == 0) {
            um c2 = this.b.c(imageFileInfo, true);
            dVar.a.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                dVar.a.invalidate();
            } else {
                this.b.d(imageFileInfo, new a(this, viewGroup), true);
            }
            dVar.a.setTagStr(this.a.getString(R.string.obfuscated_res_0x7f0f0520));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!ki.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g2 = fg.h().g(filePath, 20);
                dVar.a.setTag(g2);
                fg.h().k(filePath, 20, new b(this, viewGroup, g2), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            dVar.a.setTagStr("");
        }
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f = cVar;
        }
    }

    public void c(LinkedList<ImageFileInfo> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, linkedList) == null) {
            this.c = linkedList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.c;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.c;
            if (linkedList == null) {
                return null;
            }
            if (linkedList.size() - 1 >= i) {
                return this.c.get(i);
            }
            return 0;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view3;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                dVar = new d();
                view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d065f, (ViewGroup) null);
                dVar.a = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f090fb6);
                dVar.b = (LinearLayout) view3.findViewById(R.id.obfuscated_res_0x7f09119a);
                dVar.c = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09075f);
                dVar.a.setOnClickListener(this);
                dVar.a.setTagTextSize(li.f(this.a, R.dimen.tbds30));
                dVar.a.setDrawBorder(true);
                dVar.a.setDrawCorner(false);
                dVar.a.setRadius(0);
                dVar.b.setOnClickListener(this);
                dVar.a.setGifIconSupport(true);
                dVar.a.setLongIconSupport(true);
                SkinManager.setBackgroundResource(dVar.c, R.drawable.obfuscated_res_0x7f0806cd);
                ViewGroup.LayoutParams layoutParams = dVar.a.getLayoutParams();
                int i2 = this.d;
                layoutParams.width = i2;
                layoutParams.height = i2;
                view3.setTag(dVar);
            } else {
                view3 = view2;
                dVar = (d) view2.getTag();
            }
            LinkedList<ImageFileInfo> linkedList = this.c;
            if (linkedList != null && linkedList.size() - 1 >= i) {
                a(this.c.get(i), dVar, viewGroup);
                TbImageView tbImageView = dVar.a;
                tbImageView.setTag(tbImageView.getId(), Integer.valueOf(i));
                dVar.b.setTag(Integer.valueOf(i));
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09119a && (view2.getTag() instanceof Integer)) {
                c cVar2 = this.f;
                if (cVar2 != null) {
                    cVar2.onDeleteImage(((Integer) view2.getTag()).intValue());
                }
            } else if (id == R.id.obfuscated_res_0x7f090fb6 && (view2.getTag(view2.getId()) instanceof Integer) && (cVar = this.f) != null) {
                cVar.onClickImage(((Integer) view2.getTag(view2.getId())).intValue());
            }
        }
    }
}
