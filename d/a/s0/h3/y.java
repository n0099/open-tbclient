package d.a.s0.h3;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f61465a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f61466b;

        public a(WriteData writeData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61465a = writeData;
            this.f61466b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                d.a.c.e.d.l<String> g2 = d.a.r0.r.r.a.f().g("tb.pb_editor");
                WriteData writeData = this.f61465a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(y.d(this.f61466b), this.f61465a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(y.d(this.f61466b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f61467a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f61468b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f61469c;

        public b(WriteData writeData, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61467a = writeData;
            this.f61468b = z;
            this.f61469c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            WriteData writeData;
            WriteData writeData2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                d.a.c.e.d.l<String> g2 = d.a.r0.r.r.a.f().g("tb.pb_editor");
                WriteData writeData3 = this.f61467a;
                if (writeData3 != null && writeData3.hasContentToSave() && !this.f61468b) {
                    String draftString = this.f61467a.toDraftString();
                    g2.e(y.c(this.f61469c), draftString, 604800000L);
                    if ("0".equals(this.f61469c) || (writeData2 = this.f61467a) == null || writeData2.getStatisticFrom() != 1) {
                        return null;
                    }
                    g2.e(y.c("0"), draftString, 604800000L);
                    return null;
                }
                g2.remove(y.c(this.f61469c));
                if ("0".equals(this.f61469c) || (writeData = this.f61467a) == null || writeData.getStatisticFrom() != 1) {
                    return null;
                }
                g2.remove(y.c("0"));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f61470a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f61471b;

        public c(WriteData writeData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61470a = writeData;
            this.f61471b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                d.a.c.e.d.l<String> g2 = d.a.r0.r.r.a.f().g("tb.pb_editor");
                WriteData writeData = this.f61470a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(y.e(this.f61471b), this.f61470a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(y.e(this.f61471b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void onDraftLoaded(WriteData writeData);
    }

    /* loaded from: classes9.dex */
    public static class e extends BdAsyncTask<String, String, WriteData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d f61472a;

        /* renamed from: b  reason: collision with root package name */
        public final String f61473b;

        public e(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setPriority(3);
            this.f61472a = dVar;
            this.f61473b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public WriteData doInBackground(String... strArr) {
            String str;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    str = d.a.r0.r.r.a.f().g("tb.pb_editor").get(this.f61473b);
                } catch (Exception unused) {
                    str = null;
                }
                return WriteData.fromDraftString(str);
            }
            return (WriteData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
                super.onPostExecute(writeData);
                d dVar = this.f61472a;
                if (dVar != null) {
                    dVar.onDraftLoaded(writeData);
                }
            }
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@evaluate" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@frs" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void g(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, dVar) == null) {
            if (str != null) {
                new e(b(str), dVar).execute(new String[0]);
            } else if (dVar != null) {
                dVar.onDraftLoaded(null);
            }
        }
    }

    public static void h(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, dVar) == null) {
            if (!d.a.c.e.p.k.isEmpty(str)) {
                new e(c(str), dVar).execute(new String[0]);
            } else if (dVar != null) {
                dVar.onDraftLoaded(null);
            }
        }
    }

    public static void i(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, dVar) == null) {
            if (!d.a.c.e.p.k.isEmpty(str)) {
                new e(d(str), dVar).execute(new String[0]);
            } else if (dVar != null) {
                dVar.onDraftLoaded(null);
            }
        }
    }

    public static void j(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, dVar) == null) {
            if (!d.a.c.e.p.k.isEmpty(str)) {
                new e(e(str), dVar).execute(new String[0]);
            } else if (dVar != null) {
                dVar.onDraftLoaded(null);
            }
        }
    }

    public static void k(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, dVar) == null) {
            if (!d.a.c.e.p.k.isEmpty(str)) {
                new e(f(str), dVar).execute(new String[0]);
            } else if (dVar != null) {
                dVar.onDraftLoaded(null);
            }
        }
    }

    public static void l(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, dVar) == null) {
            if (!d.a.c.e.p.k.isEmpty(str)) {
                new e(a(str), dVar).execute(new String[0]);
            } else if (dVar != null) {
                dVar.onDraftLoaded(null);
            }
        }
    }

    public static void m(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, str, writeData) == null) || str == null) {
            return;
        }
        d.a.c.e.d.l<String> g2 = d.a.r0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.e(b(str), writeData.toDraftString(), 604800000L);
            g2.e(b(""), writeData.toDraftString(), 604800000L);
            return;
        }
        g2.remove(b(str));
        g2.remove(b(""));
    }

    public static void n(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, writeData) == null) {
            o(str, writeData, false);
        }
    }

    public static void o(String str, WriteData writeData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65550, null, str, writeData, z) == null) || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new b(writeData, z, str).execute(new Void[0]);
    }

    public static void p(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, str, writeData) == null) || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new a(writeData, str).execute(new Void[0]);
    }

    public static void q(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, str, writeData) == null) || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        new c(writeData, str).execute(new Void[0]);
    }

    public static void r(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, str, writeData) == null) || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        d.a.c.e.d.l<String> g2 = d.a.r0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.i(f(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(f(str));
        }
    }

    public static void s(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, str, writeData) == null) || d.a.c.e.p.k.isEmpty(str)) {
            return;
        }
        d.a.c.e.d.l<String> g2 = d.a.r0.r.r.a.f().g("tb.pb_editor");
        if (writeData != null) {
            g2.i(a(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(a(str));
        }
    }
}
