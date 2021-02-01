package com.kwai.player.debuginfo.model;

import androidx.annotation.Keep;
import java.io.StringWriter;
import java.util.Locale;
@Keep
/* loaded from: classes3.dex */
public class PlayerConfigDebugInfo {
    private static final String Formatter_Boolean = "%s : %b\n";
    private static final String Formatter_Int = "%s : %d\n";
    private static final String Formatter_String = "%s : %s\n";
    private static final String Formatter_Title = ">>> %s <<<\n";
    public int cacheBufferDataSourceSizeKb;
    public int cacheConnectTimeoutMs;
    public String cacheDataSourceType;
    public String cacheHeader;
    public String cacheHttpType;
    public int cacheProgressCbIntervalMs;
    public int cacheReadTimeoutMs;
    public int cacheSeekReopenTHKb;
    public int cacheSocketActKb;
    public int cacheSocketCfgKb;
    public int cacheSocketOrigKb;
    public String cacheUserAgent;
    public boolean collectFinish;
    public String inputUrl;
    public String mediaCodecInfo;
    public int playerMaxBufDurMs;
    public boolean playerStartOnPrepared;

    public String getPrettySingleText() {
        StringWriter stringWriter = new StringWriter();
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Title, "player"));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Int, "max_buffer_dur_ms", Integer.valueOf(this.playerMaxBufDurMs)));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Boolean, "start_on_prepared", Boolean.valueOf(this.playerStartOnPrepared)));
        stringWriter.append((CharSequence) "\n");
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Title, "Hodor"));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Int, "buffer_ds_size_kb", Integer.valueOf(this.cacheBufferDataSourceSizeKb)));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Int, "buffer_ds_seek_th_kb", Integer.valueOf(this.cacheSeekReopenTHKb)));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_String, "ds_type", this.cacheDataSourceType));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Int, "progress_cb_ms", Integer.valueOf(this.cacheProgressCbIntervalMs)));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_String, "http_type", this.cacheHttpType));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Int, "curl_con_timeout_ms", Integer.valueOf(this.cacheConnectTimeoutMs)));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Int, "curl_read_timeout_ms", Integer.valueOf(this.cacheReadTimeoutMs)));
        stringWriter.append((CharSequence) String.format(Locale.US, "socket, orig/cfg/act: %d/%d/%d\n", Integer.valueOf(this.cacheSocketOrigKb), Integer.valueOf(this.cacheSocketCfgKb), Integer.valueOf(this.cacheSocketActKb)));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_String, "curl_user_agent", this.cacheUserAgent));
        stringWriter.append((CharSequence) "\n");
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_Title, "HWDecode"));
        stringWriter.append((CharSequence) String.format(Locale.US, Formatter_String, "mediaCodecInfo", this.mediaCodecInfo));
        return stringWriter.toString();
    }
}
