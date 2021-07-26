package d.a.d.e.n.o;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void b() {
            ArrayList<d.a.d.e.n.j.d> c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = d.a.d.e.n.j.b.c(true)) == null || c2.size() == 0) {
                return;
            }
            int i2 = 0;
            Iterator<d.a.d.e.n.j.d> it = c2.iterator();
            while (it.hasNext()) {
                i2 = (int) (i2 + it.next().f41863a);
            }
            int i3 = i2 - IMConstants.MAX_IMAGE_CACHE_DISC_SIZE;
            ArrayList arrayList = new ArrayList();
            if (i3 > 0) {
                Collections.sort(c2, new d.a.d.e.n.j.e());
                Iterator<d.a.d.e.n.j.d> it2 = c2.iterator();
                while (it2.hasNext()) {
                    d.a.d.e.n.j.d next = it2.next();
                    arrayList.add(next.f41864b);
                    i3 = (int) (i3 - next.f41863a);
                    if (i3 <= 0) {
                        break;
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<d.a.d.e.n.j.d> it3 = c2.iterator();
            while (it3.hasNext()) {
                d.a.d.e.n.j.d next2 = it3.next();
                if (next2 != null) {
                    long j = next2.f41865c;
                    if (j != 0 && j + 604800000 < currentTimeMillis && !arrayList.contains(next2.f41864b)) {
                        arrayList.add(next2.f41864b);
                    }
                }
            }
            if (arrayList.size() > 0) {
                d.a.d.e.n.j.b.a(arrayList, true);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                b();
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new b(null).execute(new String[0]);
        }
    }
}
