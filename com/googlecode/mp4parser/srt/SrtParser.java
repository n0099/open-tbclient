package com.googlecode.mp4parser.srt;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.authoring.tracks.TextTrackImpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
/* loaded from: classes7.dex */
public class SrtParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SrtParser() {
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

    public static TextTrackImpl parse(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, inputStream)) == null) {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, "UTF-8"));
            TextTrackImpl textTrackImpl = new TextTrackImpl();
            while (lineNumberReader.readLine() != null) {
                String readLine = lineNumberReader.readLine();
                String str = "";
                while (true) {
                    String readLine2 = lineNumberReader.readLine();
                    if (readLine2 != null && !readLine2.trim().equals("")) {
                        str = String.valueOf(str) + readLine2 + "\n";
                    }
                }
                textTrackImpl.getSubs().add(new TextTrackImpl.Line(parse(readLine.split("-->")[0]), parse(readLine.split("-->")[1]), str));
            }
            return textTrackImpl;
        }
        return (TextTrackImpl) invokeL.objValue;
    }

    public static long parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? (Long.parseLong(str.split(":")[0].trim()) * 60 * 60 * 1000) + (Long.parseLong(str.split(":")[1].trim()) * 60 * 1000) + (Long.parseLong(str.split(":")[2].split(",")[0].trim()) * 1000) + Long.parseLong(str.split(":")[2].split(",")[1].trim()) : invokeL.longValue;
    }
}
