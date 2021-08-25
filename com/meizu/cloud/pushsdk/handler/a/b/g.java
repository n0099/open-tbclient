package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
        public g[] newArray(int i2) {
            return new g[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f74740a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f74741b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f74742c;

    /* renamed from: d  reason: collision with root package name */
    public b f74743d;

    /* renamed from: e  reason: collision with root package name */
    public String f74744e;

    public g(Parcel parcel) {
        this.f74740a = parcel.readInt();
        this.f74741b = parcel.readByte() != 0;
        this.f74742c = parcel.createStringArrayList();
        this.f74743d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f74744e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f74744e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f74740a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f74741b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f74742c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f74742c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            c.l.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f74743d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f74740a;
    }

    public boolean b() {
        return this.f74741b;
    }

    public List<String> c() {
        return this.f74742c;
    }

    public b d() {
        return this.f74743d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f74740a + ", wifiUpload=" + this.f74741b + ", fileList=" + this.f74742c + ", controlMessage=" + this.f74743d + ", uploadMessage='" + this.f74744e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f74740a);
        parcel.writeByte(this.f74741b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f74742c);
        parcel.writeParcelable(this.f74743d, i2);
        parcel.writeString(this.f74744e);
    }
}
