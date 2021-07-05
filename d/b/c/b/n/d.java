package d.b.c.b.n;

import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f71938a;

    /* renamed from: b  reason: collision with root package name */
    public HttpURLConnection f71939b;

    /* renamed from: c  reason: collision with root package name */
    public String f71940c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71941d;

    /* renamed from: e  reason: collision with root package name */
    public DataOutputStream f71942e;

    /* renamed from: f  reason: collision with root package name */
    public GZIPOutputStream f71943f;

    public d(String str, String str2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71940c = str2;
        this.f71941d = z;
        this.f71938a = "AAA" + System.currentTimeMillis() + "AAA";
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f71939b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.f71939b.setDoOutput(true);
        this.f71939b.setDoInput(true);
        this.f71939b.setRequestMethod("POST");
        HttpURLConnection httpURLConnection2 = this.f71939b;
        httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f71938a);
        if (z) {
            this.f71939b.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
            this.f71943f = new GZIPOutputStream(this.f71939b.getOutputStream());
            return;
        }
        this.f71942e = new DataOutputStream(this.f71939b.getOutputStream());
    }

    public String a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<String> arrayList = new ArrayList();
            byte[] bytes = ("\r\n--" + this.f71938a + "--" + Part.CRLF).getBytes();
            if (this.f71941d) {
                this.f71943f.write(bytes);
                this.f71943f.finish();
                this.f71943f.close();
            } else {
                this.f71942e.write(bytes);
                this.f71942e.flush();
                this.f71942e.close();
            }
            int responseCode = this.f71939b.getResponseCode();
            if (responseCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f71939b.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                }
                bufferedReader.close();
                this.f71939b.disconnect();
                StringBuilder sb = new StringBuilder();
                for (String str : arrayList) {
                    sb.append(str);
                }
                return sb.toString();
            }
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        return (String) invokeV.objValue;
    }

    public void b(String str, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, file) == null) {
            String name = file.getName();
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(this.f71938a);
            sb.append(Part.CRLF);
            sb.append("Content-Disposition: form-data; name=\"");
            sb.append(str);
            sb.append("\"; filename=\"");
            sb.append(name);
            sb.append("\"");
            sb.append(Part.CRLF);
            sb.append("Content-Transfer-Encoding: binary");
            sb.append(Part.CRLF);
            sb.append(Part.CRLF);
            if (this.f71941d) {
                this.f71943f.write(sb.toString().getBytes());
            } else {
                this.f71942e.write(sb.toString().getBytes());
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (this.f71941d) {
                    this.f71943f.write(bArr, 0, read);
                } else {
                    this.f71942e.write(bArr, 0, read);
                }
            }
            fileInputStream.close();
            if (this.f71941d) {
                this.f71943f.write(Part.CRLF.getBytes());
                return;
            }
            this.f71942e.write(sb.toString().getBytes());
            this.f71942e.flush();
        }
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("--");
            sb.append(this.f71938a);
            sb.append(Part.CRLF);
            sb.append("Content-Disposition: form-data; name=\"");
            sb.append(str);
            sb.append("\"");
            sb.append(Part.CRLF);
            sb.append("Content-Type: text/plain; charset=");
            sb.append(this.f71940c);
            sb.append(Part.CRLF);
            sb.append(Part.CRLF);
            sb.append(str2);
            sb.append(Part.CRLF);
            try {
                if (this.f71941d) {
                    this.f71943f.write(sb.toString().getBytes());
                } else {
                    this.f71942e.write(sb.toString().getBytes());
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
