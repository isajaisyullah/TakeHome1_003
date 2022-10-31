/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package camilan.hiling;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Isa Jaisyullah
 */

@Controller


public class myController {
    
    @RequestMapping("/view")
    public String view(
            @RequestParam(value = "vNama") String nama,
            @RequestParam(value = "vLokasi") String lokasi,
            @RequestParam(value = "vGambar") MultipartFile gambar,
            Model paket
    ) throws IOException{        
        byte[] img = gambar.getBytes();
        String bImage = Base64.encodeBase64String(img);
        String imglink= "data:image/png;base64,".concat(bImage);
        paket.addAttribute("nm", nama);
        paket.addAttribute("lk", lokasi);
        paket.addAttribute("gb", imglink);
        
        return "view";
    }
}
