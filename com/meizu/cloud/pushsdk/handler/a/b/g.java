package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.repackage.ni9;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g[] newArray(int i) {
            return new g[i];
        }
    };
    public int a;
    public boolean b;
    public List<String> c;
    public b d;
    public String e;

    public g(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readByte() != 0;
        this.c = parcel.createStringArrayList();
        this.d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.c = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.c.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e) {
            ni9.b("UploadLogMessage", "parse upload message error " + e.getMessage());
        }
        this.d = new b(str2, str3, str4);
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public List<String> c() {
        return this.c;
    }

    public b d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.a + ", wifiUpload=" + this.b + ", fileList=" + this.c + ", controlMessage=" + this.d + ", uploadMessage='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
    }
}
