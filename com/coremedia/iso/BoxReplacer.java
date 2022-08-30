package com.coremedia.iso;

import com.baidu.tieba.rw;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.Box;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.util.Path;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes7.dex */
public class BoxReplacer {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1540282720, "Lcom/coremedia/iso/BoxReplacer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1540282720, "Lcom/coremedia/iso/BoxReplacer;");
        }
    }

    public BoxReplacer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void replace(Map<String, Box> map, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, map, file) == null) {
            IsoFile isoFile = new IsoFile(new FileDataSourceImpl(file), new PropertyBoxParserImpl(new String[0]));
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Box> entry : map.entrySet()) {
                hashMap.put(Path.createPath(Path.getPath(isoFile, entry.getKey())), entry.getValue());
            }
            isoFile.close();
            FileChannel channel = new RandomAccessFile(file, rw.c).getChannel();
            Iterator it = hashMap.entrySet().iterator();
            if (!it.hasNext()) {
                channel.close();
            } else {
                String str = (String) ((Map.Entry) it.next()).getKey();
                throw new RuntimeException("ddd");
            }
        }
    }
}
